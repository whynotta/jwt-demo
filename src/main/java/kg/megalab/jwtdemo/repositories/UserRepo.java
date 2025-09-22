package kg.megalab.jwtdemo.repositories;

import kg.megalab.jwtdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional <User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
