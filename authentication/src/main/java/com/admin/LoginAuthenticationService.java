package com.admin;

import com.admin.entities.UnvalidatedLoginAuthenticationRequest;
import com.admin.entities.ValidatedLoginAuthentication;
import com.admin.entities.ValidationErrors;
import io.vavr.control.Validation;

public record LoginAuthenticationService(LoginAuthenticationDao loginAuthenticationDao) {
    public Validation<ValidationErrors, String> loginAuthentication(UnvalidatedLoginAuthenticationRequest request) {
        return ValidatedLoginAuthentication.validate(request)
                .map(LoginAuthenticationDao::loginAuthentication)
                .flatMap()
    }
}
