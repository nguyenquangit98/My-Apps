package com.admin.authentication.dao;

import com.admin.LoginAuthenticationDao;
import com.admin.entities.LoginAuthenticationResponse;
import com.admin.entities.ValidatedLoginAuthenticationRequest;
import io.vavr.control.Try;
import org.springframework.stereotype.Component;

@Component
public record AuthenticationDaoImpl(AuthenticationRepository repository)
        implements LoginAuthenticationDao {

    @Override
    public Try<LoginAuthenticationResponse> loginAuthentication(ValidatedLoginAuthenticationRequest validatedLoginAuthentication) {
        return Try.ofSupplier(() -> {
            if(repository.existsByUsernameAndPassword(validatedLoginAuthentication.username(),
                    validatedLoginAuthentication.password())){
                return LoginAuthenticationResponse.builder().username(validatedLoginAuthentication.username()).build();
            }
            return LoginAuthenticationResponse.builder().username("").build();
        });
    }

    @Override
    public Try<Boolean> isExistedUsername(String username) {
        return Try.ofSupplier(() -> repository.existsByUsername(username));
    }
}
