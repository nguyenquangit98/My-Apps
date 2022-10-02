package com.admin.entities;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ErrorHandler {
    private String profile;

    public <T> ResponseObject<T> getError(GlobalServiceError error) {
        if (error instanceof DatabaseConnectionError) {
            Throwable t = ((DatabaseConnectionError) error).error();
            t.printStackTrace();
            if (profile.equals("qa")) {
                return ResponseObject.error("Internal server error", Map.of("error", t.getMessage()));
            }
            return ResponseObject.error("Internal server error", Map.of());
        }
        if (error instanceof ValidationErrors) {
            return ResponseObject.error("Validation error"
                    , ((ValidationErrors) error).getErrors().stream().collect(Collectors.toMap(ValidationError::name, ValidationError::message)));
        }
        return ResponseObject.error("Unknown error");
    }
}

