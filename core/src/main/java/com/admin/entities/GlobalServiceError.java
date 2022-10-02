package com.admin.entities;


public sealed interface GlobalServiceError permits DatabaseConnectionError, ValidationErrors{
    ValidationError getError();
}

