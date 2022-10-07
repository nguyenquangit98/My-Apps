package com.admin.core.entities;


public sealed interface GlobalServiceError permits DatabaseConnectionError, ValidationErrors{
    ValidationError getError();
}

