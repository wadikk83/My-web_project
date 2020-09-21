package by.wadikk;


import by.wadikk.repository.UserRepository;
import by.wadikk.repository.model.Address;
import by.wadikk.repository.model.User;
import by.wadikk.repository.model.security.Role;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

@SpringBootApplication
@EnableWebSecurity
@EnableSwagger2
@Configuration
public class ApplicationStarter implements InitializingBean {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    @Autowired
    UserRepository repo;

    @Override
    public void afterPropertiesSet() throws Exception {
        repo.save(user("admin@tut.by", "admin", "admin", Role.ADMIN));
    }

    private User user(String email, String login, String password, Role role) {
        User entity = new User();
        entity.setLogin(login);
        entity.setPassword(password);
        entity.setEmail(email);
        entity.setRole(role);
        return entity;
    }


}
