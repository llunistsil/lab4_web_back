package ifmo.labs.lab4_web_back.repos;

import ifmo.labs.lab4_web_back.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    void deleteByLogin(String login);
}
