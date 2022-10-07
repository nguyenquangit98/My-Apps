package com.admin.keycloak;

import io.vavr.control.Try;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public interface KeycloakService {
    Try<Keycloak> getInstance();
    Try<Keycloak> loginKeycloak(String username, String password);
}
