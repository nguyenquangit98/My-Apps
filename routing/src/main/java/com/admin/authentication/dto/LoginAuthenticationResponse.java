package com.admin.authentication.dto;

import com.admin.entities.ResponseObject;

public class LoginAuthenticationResponse extends ResponseObject<String> {
    public LoginAuthenticationResponse(ResponseObject<String> responseObject) {
        super(responseObject.getData(), responseObject.getMessage(), responseObject.getErrors());
    }
}
