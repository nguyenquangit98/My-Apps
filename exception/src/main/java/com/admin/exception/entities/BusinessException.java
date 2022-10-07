package com.admin.exception.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException {

    private ExceptionCode exceptionCode;
    private Object[] args;

    public BusinessException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }

    public BusinessException(ExceptionCode exceptionCode, Object[] args) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
        this.args = args;
    }
}