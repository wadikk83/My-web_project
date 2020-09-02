package by.wadikk.service;

import by.wadikk.repository.model.User;

public interface UserService extends CrudService<User> {

    User findById (Integer id);

    User findByUserName (String userName);

    User findByEmail (String email);



}
