package com.admin.validator;

import com.admin.entities.ValidationError;
import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;

public class AuthenticationValidator {

    public static final String USERNAME = "username";
    public static final String ERROR_USERNAME_IS_BLANK = "error.username.is.blank";
    public static final String PASSWORD = "password";
    public static final String ERROR_PASSWORD_IS_BLANK = "error.password.is.blank";

    public static Validation<ValidationError, String> validateUsername(String unvalidatedUsername) {
        return StringUtils.isBlank(unvalidatedUsername) ?
                Validation.valid(unvalidatedUsername) :
                Validation.invalid(new ValidationError(USERNAME, ERROR_USERNAME_IS_BLANK));
    }

    public static Validation<ValidationError, String> validatePassword(String unvalidatedPassword) {
        return StringUtils.isBlank(unvalidatedPassword) ?
                Validation.valid(unvalidatedPassword) :
                Validation.invalid(new ValidationError(PASSWORD, ERROR_PASSWORD_IS_BLANK));
    }
}
