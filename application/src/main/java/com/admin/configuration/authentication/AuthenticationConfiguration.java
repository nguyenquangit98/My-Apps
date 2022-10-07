package com.admin.configuration.authentication;

import com.admin.LoginAuthenticationDao;
import com.admin.LoginAuthenticationService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.admin.authentication.dao")
@EntityScan("com.admin.authentication.dao.orm")
@ComponentScan("com.admin.authentication.dao")
public class AuthenticationConfiguration {
    @Bean
    public LoginAuthenticationService loginAuthenticationService(LoginAuthenticationDao loginAuthenticationDao) {
        return new LoginAuthenticationService(loginAuthenticationDao);
    }

}
