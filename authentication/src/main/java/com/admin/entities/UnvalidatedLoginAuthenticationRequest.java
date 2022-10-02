package com.admin.entities;

import lombok.Builder;

@Builder(toBuilder = true)
public record UnvalidatedLoginAuthenticationRequest(String username, String password) {
}
