package com.admin.entities;

import lombok.Builder;

@Builder(toBuilder = true)
public record LoginAuthenticationResponse(String username,
                                          String accessToken,
                                          String refreshToken)  {
}
