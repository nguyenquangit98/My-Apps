package com.admin.exception;

import io.vavr.control.Try;

import java.util.Locale;

public interface MessageService {
    Try<String> getMessage(String key, Object[] args);
    Try<String> getMessage(String key, Object[] args, Locale locale);
}
