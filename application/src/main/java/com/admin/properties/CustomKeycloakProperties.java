package com.admin.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "custom-keycloak")
public class CustomKeycloakProperties {
    private String adminClient;
    private String adminClientUser;
    private String adminClientSecret;
}
