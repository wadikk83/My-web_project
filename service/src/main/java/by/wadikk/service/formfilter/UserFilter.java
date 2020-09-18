package by.wadikk.service.formfilter;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserFilter {
    private String login;
    private String password;
    private String firstName;
    private String lastName;


}
