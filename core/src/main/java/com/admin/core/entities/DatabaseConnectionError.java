package com.admin.core.entities;


public record DatabaseConnectionError(Throwable error) implements GlobalServiceError {
    @Override
    public ValidationError getError() {
        return new ValidationError("global", ErrorMessage.ERROR_GLOBAL_UNKNOWN);
    }
}
