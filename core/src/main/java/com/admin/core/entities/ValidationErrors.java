package com.admin.core.entities;

import java.util.List;
import java.util.stream.Collectors;

public record ValidationErrors (List<ValidationError> errors) implements GlobalServiceError {

    public static ValidationErrors flat(List<ValidationErrors> errors) {
        return new ValidationErrors(errors.stream().flatMap(e -> e.getErrors().stream()).collect(Collectors.toList()));
    }

    public ValidationError first() {
        return errors.get(0);
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public static ValidationErrors getErrorMessage(String errorName, String errorMessage) {
        return new ValidationErrors(List.of(new ValidationError(errorName, errorMessage)));
    }

    @Override
    public ValidationError getError() {
        return first();
    }
}
