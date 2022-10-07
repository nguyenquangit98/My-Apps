package com.admin.exception.entities;

import lombok.Getter;

@Getter
public enum ExceptionCode {

    INTERNAL_SERVER_ERROR(400, "error.internal.server.error" );

    private final Integer code;
    private final String message;

    ExceptionCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
