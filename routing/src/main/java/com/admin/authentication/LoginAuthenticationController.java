package com.admin.authentication;

import com.admin.LoginAuthenticationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public record LoginAuthenticationController(LoginAuthenticationService loginService) {

}
