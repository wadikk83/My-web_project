package by.wadikk.repository.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "USER_TABLE")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @Email
    @NotNull
    private String email;

    //@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "address_id")
    //private Address address;
}
