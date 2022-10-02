package com.admin.validator;

import com.admin.entities.ValidationError;
import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;

public class AuthenticationValidator {
    public static Validation<Exception, String> validateUsername(String unvalidatedUsername) {
        return StringUtils.isBlank(unvalidatedUsername) ?
                Validation.valid(unvalidatedUsername) :
                Validation.invalid(new RuntimeException());
    }
}
