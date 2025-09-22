package kg.megalab.jwtdemo.services;


import kg.megalab.jwtdemo.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    void save(User user);

    UserDetailsService userDetailsService();

    void getAdmin();
}
