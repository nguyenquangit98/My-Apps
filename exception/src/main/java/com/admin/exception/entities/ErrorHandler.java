package com.admin.exception.entities;

import com.admin.core.entities.*;
import com.admin.exception.MessageService;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public record ErrorHandler(MessageService messageService) {
    public <T> ResponseObject<T> getError(GlobalServiceError error) {
        if (error instanceof DatabaseConnectionError) {
            return this.getMessage(ExceptionCode.INTERNAL_SERVER_ERROR);
        }
        if (error instanceof ValidationErrors) {
            return ResponseObject.error(500, "Validation Error"
                    , ((ValidationErrors) error).getErrors().stream().collect(Collectors.toMap(ValidationError::name, ValidationError::message)));
        }
        return this.getMessage(ExceptionCode.INTERNAL_SERVER_ERROR);
    }

    private <T> ResponseObject<T> getMessage(ExceptionCode exceptionCode){
        return ResponseObject.error(exceptionCode.getCode(), messageService.getMessage(exceptionCode.getMessage(), null, new Locale("vi")), Map.of());
    }
}
