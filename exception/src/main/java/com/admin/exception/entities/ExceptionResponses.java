package com.admin.exception.entities;

import com.admin.core.entities.ResponseObject;

public class ExceptionResponses extends ResponseObject<ExceptionResponse> {
    public ExceptionResponses(ResponseObject<ExceptionResponse> responseObject) {
        super(responseObject.getData(), responseObject.getCode(), responseObject.getMessage(), responseObject.getErrors());
    }
}
