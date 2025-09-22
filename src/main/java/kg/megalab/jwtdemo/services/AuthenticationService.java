package kg.megalab.jwtdemo.services;

import jakarta.validation.Valid;
import kg.megalab.jwtdemo.models.dto.JwtAuthenticationResponse;
import kg.megalab.jwtdemo.models.dto.SignInRequest;
import kg.megalab.jwtdemo.models.dto.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signIn(@Valid SignInRequest request);
}
