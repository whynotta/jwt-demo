package kg.megalab.jwtdemo.services.impl;

import kg.megalab.jwtdemo.models.User;
import kg.megalab.jwtdemo.repositories.UserRepo;
import kg.megalab.jwtdemo.services.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void save(User user) {
        userRepo.save(user);

    }

    @Override
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    @Override
    public void getAdmin() {

    }

    public User getByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow(()
                -> new UsernameNotFoundException("Пользователь не найден " + username));

    }
}
