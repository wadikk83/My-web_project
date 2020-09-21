package by.wadikk.service;


import by.wadikk.service.dto.UserDetailsDTO;

public interface RegistrationService {

	void registerUser(UserDetailsDTO user);

	void activateUser(String login);
	
}
