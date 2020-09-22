package by.wadikk.config;

import by.wadikk.service.impl.UserSecurityServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter implements InitializingBean {
    @Autowired
    private SpringTemplateEngine engine;

	@Autowired
    private UserSecurityServiceImpl service;

    private static final String[] PUBLIC_MATCHERS = {
            "/css/**",
            "/js/**",
            "/image/**",
            "/",
            "/new-user",
            "/login",
            "/store",
            "/product-detail"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers("/login").permitAll()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf()
                .and()
                .rememberMe()
                .rememberMeParameter("rememberme")
                .userDetailsService(service)
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access_denied");
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		engine.addDialect(new SpringSecurityDialect());

	}
}


