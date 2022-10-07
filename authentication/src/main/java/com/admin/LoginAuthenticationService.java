package com.admin;

import com.admin.core.entities.DatabaseConnectionError;
import com.admin.core.entities.GlobalServiceError;
import com.admin.entities.UnvalidatedLoginAuthenticationRequest;
import com.admin.entities.ValidatedLoginAuthentication;
import io.vavr.control.Validation;

public record LoginAuthenticationService(LoginAuthenticationDao loginAuthenticationDao) {
    public Validation<GlobalServiceError, String> loginAuthentication(UnvalidatedLoginAuthenticationRequest request) {
        return ValidatedLoginAuthentication.validate(request, loginAuthenticationDao)
                .map(loginAuthenticationDao::loginAuthentication)
                .mapError(GlobalServiceError.class::cast)
                .flatMap(tryCheck -> tryCheck.toValidation(DatabaseConnectionError::new));
    }
}
