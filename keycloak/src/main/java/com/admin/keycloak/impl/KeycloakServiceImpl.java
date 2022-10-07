package com.admin.keycloak.impl;

import com.admin.keycloak.KeycloakService;
import io.vavr.control.Try;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public record KeycloakServiceImpl(String realm,
                                  String serverUrl,
                                  String clientId,
                                  String clientSecret) implements KeycloakService {

    @Override
    public Try<Keycloak> getInstance() {
        return Try.ofSupplier(() -> KeycloakBuilder.builder()
                .realm(realm)
                .serverUrl(serverUrl)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build());
    }

    @Override
    public Try<Keycloak> loginKeycloak(String username, String password) {
        return Try.ofSupplier(() -> KeycloakBuilder.builder()
                .realm(realm)
                .serverUrl(serverUrl)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .username(username)
                .password(password)
                .build());
    }
}
