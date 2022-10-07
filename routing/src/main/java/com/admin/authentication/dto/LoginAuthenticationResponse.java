package com.admin.authentication.dto;

import com.admin.core.entities.ResponseObject;

public class LoginAuthenticationResponse extends ResponseObject<String> {
    public LoginAuthenticationResponse(ResponseObject<String> responseObject) {
        super(responseObject.getData(), responseObject.getCode(), responseObject.getMessage(), responseObject.getErrors());
    }
}
