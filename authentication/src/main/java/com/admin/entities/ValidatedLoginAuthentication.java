package com.admin.entities;

import io.vavr.control.Validation;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record ValidatedLoginAuthentication(String username, String password) {
    public static Validation<GlobalServiceError, ValidatedLoginAuthentication> validate(UnvalidatedLoginAuthenticationRequest unvalidatedRequest){
        return Validation.combine()

    }
}
