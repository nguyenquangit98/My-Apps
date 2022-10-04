package com.admin.keycloak.entities;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.vavr.control.Try;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public record AccessToken(String token) {

    public static final String BEARER = "Bearer ";
    public static final String REALM_ACCESS = "realm_access";
    public static final String ROLE = "roles";
    public static final String PREFERRED_USERNAME = "preferred_username";

    public String getValue() {
        return token;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getPayloadAsJsonObject()
                .map(json -> StreamSupport.stream(
                                json.getAsJsonObject(REALM_ACCESS).getAsJsonArray(ROLE).spliterator(), false)
                        .map(JsonElement::getAsString)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())).get();
    }

    public Optional<String> getUsername() {
        return getPayloadAsJsonObject()
                .map(v -> v.getAsJsonPrimitive(PREFERRED_USERNAME).getAsString())
                .map(Optional::ofNullable)
                .get();
    }

    private Try<JsonObject> getPayloadAsJsonObject() {
        return decodeToken(token).flatMap(this::decodeTokenPayloadToJsonObject);
    }

    private Try<DecodedJWT> decodeToken(String token) {
        return Try.ofSupplier(() -> JWT.decode(token));
    }

    private Try<JsonObject> decodeTokenPayloadToJsonObject(DecodedJWT decodedJWT) {
        return Try.ofSupplier(() -> new Gson().fromJson(
                new String(Base64.getDecoder().decode(decodedJWT.getPayload()), StandardCharsets.UTF_8),
                JsonObject.class));
    }
}

