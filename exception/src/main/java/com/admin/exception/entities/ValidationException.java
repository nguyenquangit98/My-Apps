package com.admin.exception.entities;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {

    private final ExceptionCode exceptionCode;
    private Object[] args;

    public ValidationException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }

    public ValidationException(ExceptionCode exceptionCode, Object[] args) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
        this.args = args;
    }
}
