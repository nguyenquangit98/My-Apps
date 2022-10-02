package com.admin;

import org.springframework.stereotype.Component;

@Component
public record AuthenticationDaoImpl(AuthenticationRepository repository)
        implements LoginAuthenticationDao {

}
