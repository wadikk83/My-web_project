package by.wadikk.service;

import by.wadikk.repository.model.User;
import by.wadikk.service.dto.UserDetailsDTO;

import javax.validation.Valid;

public interface UserRegistrationService {

        @Valid User registerUser(UserDetailsDTO user);

        void activateUser(String login);

}
