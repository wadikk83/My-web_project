package by.wadikk.service.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
public class UserDetailsDTO {

    @Length(min = 5)
    private String password;
    private String login;
    @Email
    private String email;

}
