package com.admin.validator;

import com.admin.LoginAuthenticationDao;
import com.admin.core.entities.ValidationError;
import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;

import static com.admin.core.entities.ErrorMessage.*;

public class AuthenticationValidator {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String GLOBAL = "global";

    public static Validation<ValidationError, String> validateUsername(String unvalidatedUsername,
                                                                       LoginAuthenticationDao loginAuthenticationDao) {
        if (StringUtils.isBlank(unvalidatedUsername)) {
            return Validation.invalid(new ValidationError(USERNAME, ERROR_USERNAME_IS_BLANK));
        }
        return loginAuthenticationDao.isExistedUsername(unvalidatedUsername)
                .toValidation(new ValidationError(GLOBAL, ERROR_GLOBAL_UNKNOWN))
                .flatMap(existed -> existed
                        ? Validation.valid(unvalidatedUsername)
                        : Validation.invalid(new ValidationError(USERNAME, ERROR_USERNAME_NOT_FOUND)));
    }

    public static Validation<ValidationError, String> validatePassword(String unvalidatedPassword) {
        if (StringUtils.isBlank(unvalidatedPassword)) {
            return Validation.invalid(new ValidationError(PASSWORD, ERROR_PASSWORD_IS_BLANK));
        }
        return Validation.valid(unvalidatedPassword);
    }
}
