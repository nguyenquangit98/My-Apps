package com.admin;

import com.admin.entities.ValidatedLoginAuthentication;
import io.vavr.control.Try;
import org.springframework.stereotype.Component;

@Component
public record AuthenticationDaoImpl(AuthenticationRepository repository)
        implements LoginAuthenticationDao {

    @Override
    public Try<String> loginAuthentication(ValidatedLoginAuthentication validatedLoginAuthentication) {
        return Try.ofSupplier(() -> {
            if(repository.existsByUsername(validatedLoginAuthentication.username())){
                return validatedLoginAuthentication.username();
            }
            return null;
        });
    }
}
