package com.admin.entities;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import lombok.AccessLevel;
import lombok.Builder;

import static com.admin.validator.AuthenticationValidator.validatePassword;
import static com.admin.validator.AuthenticationValidator.validateUsername;

@Builder(access = AccessLevel.PRIVATE)
public record ValidatedLoginAuthentication(String username, String password) {
    public static Validation<ValidationErrors, ValidatedLoginAuthentication> validate(UnvalidatedLoginAuthenticationRequest unvalidatedRequest){
        return Validation.combine(validateUsername(unvalidatedRequest.username()),
                validatePassword(unvalidatedRequest.password()))
                .ap(ValidatedLoginAuthentication::new)
                .mapError(Seq::asJava)
                .mapError(ValidationErrors::new);
    }
}
