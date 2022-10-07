package com.admin.mapper;

import com.admin.entities.LoginAuthenticationResponse;
import org.keycloak.representations.AccessTokenResponse;

public class AuthenticationMapper {

    public static LoginAuthenticationResponse toResponse(AccessTokenResponse accessTokenResponse){
        return LoginAuthenticationResponse.builder()
                .accessToken(accessTokenResponse.getToken())
                .refreshToken(accessTokenResponse.getRefreshToken())
                .build();
    }
}
