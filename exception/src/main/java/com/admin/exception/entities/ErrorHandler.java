package com.admin.exception.entities;

import com.admin.core.entities.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ErrorHandler {
    public <T> ResponseObject<T> getError(GlobalServiceError error) {
        if (error instanceof DatabaseConnectionError) {
            return ResponseObject.error(500, "Internal server error", Map.of());
        }
        if (error instanceof ValidationErrors) {
            return ResponseObject.error(500, "Validation error"
                    , ((ValidationErrors) error).getErrors().stream().collect(Collectors.toMap(ValidationError::name, ValidationError::message)));
        }
        return ResponseObject.error(500, "error.internal.server.error");
    }
}
