package by.wadikk.service.impl;

import by.wadikk.repository.model.User;
import by.wadikk.repository.model.security.Role;
import by.wadikk.service.UserRegistrationService;
import by.wadikk.service.UserService;
import by.wadikk.service.dto.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserService userService;

    @Override
    public @javax.validation.Valid User registerUser(UserDetailsDTO user) {
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

        return u;
    }

    @Override
    public void activateUser(String login) {
        User byLogin = userService.getByLogin(login);
        byLogin.setActive(Boolean.TRUE);
        userService.save(byLogin);

    }
}
