package com.admin.authentication.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record LoginAuthenticationRequest(String username, String password) {

}
