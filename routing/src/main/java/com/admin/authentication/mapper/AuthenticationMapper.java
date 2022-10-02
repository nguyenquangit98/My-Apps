package com.admin.authentication.mapper;

import com.admin.authentication.dto.LoginAuthenticationRequest;
import com.admin.entities.UnvalidatedLoginAuthenticationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthenticationMapper {
    UnvalidatedLoginAuthenticationRequest toEntity(LoginAuthenticationRequest request);
}
