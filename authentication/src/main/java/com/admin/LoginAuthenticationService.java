package com.admin;

import com.admin.core.entities.DatabaseConnectionError;
import com.admin.core.entities.GlobalServiceError;
import com.admin.core.entities.ValidationError;
import com.admin.core.entities.ValidationErrors;
import com.admin.entities.LoginAuthenticationResponse;
import com.admin.entities.UnvalidatedLoginAuthenticationRequest;
import com.admin.entities.ValidatedLoginAuthenticationRequest;
import com.admin.keycloak.KeycloakService;
import com.admin.mapper.AuthenticationMapper;
import io.vavr.control.Validation;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.token.TokenManager;
import org.keycloak.representations.AccessTokenResponse;

import java.util.List;

public record LoginAuthenticationService(LoginAuthenticationDao loginAuthenticationDao,
                                         KeycloakService keycloakService) {
    public Validation<GlobalServiceError, LoginAuthenticationResponse> loginAuthentication(UnvalidatedLoginAuthenticationRequest request) {
        return ValidatedLoginAuthenticationRequest.validate(request, loginAuthenticationDao)
                .map(loginAuthenticationDao::loginAuthentication)
                .mapError(GlobalServiceError.class::cast)
                .flatMap(tryCheck -> tryCheck.toValidation(DatabaseConnectionError::new))
                .map();
    }

    private Validation<GlobalServiceError, LoginAuthenticationResponse> loginKeycloak(ValidatedLoginAuthenticationRequest validatedLoginAuthentication) {
        return keycloakService.loginKeycloak(validatedLoginAuthentication.username(), validatedLoginAuthentication.password())
                .toValidation(DatabaseConnectionError::new)
                .mapError(GlobalServiceError.class::cast)
                .map(Keycloak::tokenManager)
                .map(TokenManager::getAccessToken)
                .flatMap(this::keycloakResponse);
    }

    private Validation<GlobalServiceError, LoginAuthenticationResponse> keycloakResponse(AccessTokenResponse accessTokenResponse) {
        if (accessTokenResponse.getError() == null) {
            return Validation.valid(AuthenticationMapper.toResponse(accessTokenResponse));
        }
        return Validation.invalid(new ValidationErrors(List.of(new ValidationError("keycloak", accessTokenResponse.getError()))));
    }
}
