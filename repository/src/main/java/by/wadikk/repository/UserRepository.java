package by.wadikk.repository;

import by.wadikk.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByLogin(String login);

    User findByEmail(String email);
}
