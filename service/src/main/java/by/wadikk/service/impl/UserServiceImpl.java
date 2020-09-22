package by.wadikk.service.impl;

import by.wadikk.repository.repository.UserRepository;
import by.wadikk.repository.model.User;
import by.wadikk.repository.model.security.Role;
import by.wadikk.service.UserService;
import by.wadikk.service.filter.UserFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends CrudServiceJpaRepoImpl<User> implements UserService {

    @Autowired
    UserRepository userRepository;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public List<User> getByFilter(UserFilter filter) {
        return userRepository.findAll(Example.of(MAPPER.convertValue(filter, User.class)));
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public boolean checkLoginPresent(String login) {
        return getByLogin(login) != null;
    }

    @Override
    public Page<User> getPage(Integer pageNum, Integer pageSize) {
        return userRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    @Override
    public User createUser(String login, String password, String email) {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            return user;
        } else {
            user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setActive(Boolean.FALSE);
            user.setRole(Role.USER);

            return userRepository.save(user);
        }

    }
}
