package com.admin.authentication.dao;

import com.admin.LoginAuthenticationDao;
import com.admin.entities.ValidatedLoginAuthentication;
import io.vavr.control.Try;
import org.springframework.stereotype.Component;

@Component
public record AuthenticationDaoImpl(AuthenticationRepository repository)
        implements LoginAuthenticationDao {

    @Override
    public Try<String> loginAuthentication(ValidatedLoginAuthentication validatedLoginAuthentication) {
        return Try.ofSupplier(() -> {
            if(repository.existsByUsernameAndPassword(validatedLoginAuthentication.username(),
                    validatedLoginAuthentication.password())){
                return validatedLoginAuthentication.username();
            }
            return null;
        });
    }

    @Override
    public Try<Boolean> isExistedUsername(String username) {
        return Try.ofSupplier(() -> repository.existsByUsername(username));
    }
}
