package by.wadikk.service;

import by.wadikk.repository.model.User;
import by.wadikk.service.formfilter.UserFilter;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService extends CrudService<User> {

    List<User> getByFilter(UserFilter filter);

    User getByEmail(String email);

    User getByLogin(String login);

    boolean checkLoginPresent(String login);

    Page<User> getPage(Integer pageNum, Integer pageSize);

}
