package com.admin;

import com.admin.entities.ValidatedLoginAuthentication;
import io.vavr.control.Try;

public interface LoginAuthenticationDao {
    Try<String> loginAuthentication(ValidatedLoginAuthentication validatedLoginAuthentication);
}
