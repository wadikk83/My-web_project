package by.wadikk.service.impl;

import by.wadikk.repository.model.User;
import by.wadikk.repository.model.security.Role;
import by.wadikk.service.RegistrationService;
import by.wadikk.service.UserService;
import by.wadikk.service.dto.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserService userService;

    @Override
    public void registerUser(UserDetailsDTO user) {
        if (userService.checkLoginPresent(user.getLogin())) {
            throw new RuntimeException("User is present");
        }

        User u = new User();
        u.setLogin(user.getLogin());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setActive(Boolean.FALSE);
        u.setRole(Role.USER);

        userService.save(u);
    }

    @Override
    public void activateUser(String login) {

    }
}
