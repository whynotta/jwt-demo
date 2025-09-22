package kg.megalab.jwtdemo.services.impl;

import kg.megalab.jwtdemo.models.User;
import kg.megalab.jwtdemo.models.dto.JwtAuthenticationResponse;
import kg.megalab.jwtdemo.models.dto.SignInRequest;
import kg.megalab.jwtdemo.models.dto.SignUpRequest;
import kg.megalab.jwtdemo.models.enums.UserRole;
import kg.megalab.jwtdemo.services.AuthenticationService;
import kg.megalab.jwtdemo.services.JwtService;
import kg.megalab.jwtdemo.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UserService userService, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest signUpRequest) {
        User user = User
                .builder()
                .username(signUpRequest.getUsername())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .email(signUpRequest.getEmail())
                .role(UserRole.USER)
                .build();

        userService.save(user);

        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));
        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);

    }
}