package com.admin.authentication;

import com.admin.LoginAuthenticationService;
import com.admin.authentication.dto.LoginAuthenticationRequest;
import com.admin.authentication.dto.LoginAuthenticationResponse;
import com.admin.authentication.mapper.AuthenticationMapper;
import com.admin.core.entities.ResponseObject;
import com.admin.exception.entities.ErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.function.Function.identity;

@RestController
@RequestMapping("/api/authentication")
public record LoginAuthenticationController(LoginAuthenticationService loginService,
                                            AuthenticationMapper mapper,
                                            ErrorHandler errorHandler) {
    @PostMapping(value = "/")
    public ResponseEntity<LoginAuthenticationResponse> loginAuthentication(@RequestBody LoginAuthenticationRequest request) {
        return loginService.loginAuthentication(mapper.toEntity(request))
                .map(ResponseObject::of)
                .map(LoginAuthenticationResponse::new)
                .map(ResponseEntity::ok)
                .mapError(errorHandler::<String>getError)
                .mapError(LoginAuthenticationResponse::new)
                .mapError(ResponseEntity.badRequest()::body)
                .fold(identity(), identity());
    }
}
