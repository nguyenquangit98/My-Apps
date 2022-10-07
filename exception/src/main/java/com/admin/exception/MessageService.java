package com.admin.exception;

import io.vavr.control.Try;

import java.util.Locale;

public interface MessageService {
    String getMessage(String key, Object[] args);
    String getMessage(String key, Object[] args, Locale locale);
}
