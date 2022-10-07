package com.admin;

import com.admin.entities.LoginAuthenticationResponse;
import com.admin.entities.ValidatedLoginAuthenticationRequest;
import io.vavr.control.Try;

public interface LoginAuthenticationDao {
    Try<LoginAuthenticationResponse> loginAuthentication(ValidatedLoginAuthenticationRequest validatedLoginAuthentication);
    Try<Boolean> isExistedUsername(String username);
}
