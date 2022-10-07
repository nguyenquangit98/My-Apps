package com.admin.entities;

import com.admin.LoginAuthenticationDao;
import com.admin.core.entities.ValidationErrors;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;

import static com.admin.validator.AuthenticationValidator.validatePassword;
import static com.admin.validator.AuthenticationValidator.validateUsername;

public record ValidatedLoginAuthenticationRequest(String username, String password) {
    public static Validation<ValidationErrors, ValidatedLoginAuthenticationRequest> validate(UnvalidatedLoginAuthenticationRequest unvalidatedRequest,
                                                                                             LoginAuthenticationDao loginAuthenticationDao) {
        return Validation.combine(validateUsername(unvalidatedRequest.username(), loginAuthenticationDao),
                        validatePassword(unvalidatedRequest.password()))
                .ap(ValidatedLoginAuthenticationRequest::new)
                .mapError(Seq::asJava)
                .mapError(ValidationErrors::new);
    }
}