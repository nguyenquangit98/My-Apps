package com.admin.keycloak.configuration;

import com.admin.keycloak.entities.AccessToken;
import lombok.ToString;
import org.springframework.security.authentication.AbstractAuthenticationToken;

@ToString
public class JwtAuthentication extends AbstractAuthenticationToken {

    private final AccessToken accessToken;

    public JwtAuthentication(AccessToken accessToken) {
        super(accessToken.getAuthorities());
        this.accessToken = accessToken;
    }

    @Override
    public Object getCredentials() {
        return accessToken.getValue();
    }

    @Override
    public Object getPrincipal() {
        return accessToken.getUsername();
    }
}
