package com.admin;

import com.admin.configuration.AuthenticationConfiguration;
import com.admin.configuration.RoutingConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({RoutingConfiguration.class,
        AuthenticationConfiguration.class})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}