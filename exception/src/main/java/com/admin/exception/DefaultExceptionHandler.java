package com.admin.exception;

import com.admin.core.entities.DatabaseConnectionError;
import com.admin.core.entities.ResponseObject;
import com.admin.exception.entities.*;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.admin.exception.entities.ExceptionCode.INTERNAL_SERVER_ERROR;
import static java.util.function.Function.identity;

@ControllerAdvice
public record DefaultExceptionHandler(MessageService messageService, ErrorHandler errorHandler) {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponses> handleException() {
        return messageService.getMessage(INTERNAL_SERVER_ERROR.getMessage(), null, LocaleContextHolder.getLocale())
                .toValidation(DatabaseConnectionError::new)
                .map(message -> new ExceptionResponse(INTERNAL_SERVER_ERROR.getCode(), message))
                .map(ResponseObject::of)
                .map(ExceptionResponses::new)
                .map(ResponseEntity.badRequest()::body)
                .mapError(errorHandler::<ExceptionResponse>getError)
                .mapError(ExceptionResponses::new)
                .mapError(ResponseEntity.badRequest()::body)
                .fold(identity(), identity());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionResponses> handleValidateException(ValidationException e) {
        return getExceptionResponsesResponseEntity(e.getExceptionCode(), e.getArgs());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponses> handleValidateException(BusinessException e) {
        return getExceptionResponsesResponseEntity(e.getExceptionCode(), e.getArgs());
    }

    private ResponseEntity<ExceptionResponses> getExceptionResponsesResponseEntity(ExceptionCode exceptionCode, Object[] args) {
        return messageService.getMessage(exceptionCode.getMessage(), args, LocaleContextHolder.getLocale())
                .toValidation(DatabaseConnectionError::new)
                .map(message -> new ExceptionResponse(exceptionCode.getCode(), message))
                .map(ResponseObject::of)
                .map(ExceptionResponses::new)
                .map(ResponseEntity.badRequest()::body)
                .mapError(errorHandler::<ExceptionResponse>getError)
                .mapError(ExceptionResponses::new)
                .mapError(ResponseEntity.badRequest()::body)
                .fold(identity(), identity());
    }
}
