package com.admin.exception.impl;

import com.admin.exception.MessageService;
import io.vavr.control.Try;
import org.springframework.context.MessageSource;

import java.util.Locale;

public record MessageServiceImpl(MessageSource messageSource) implements MessageService {

    @Override
    public Try<String> getMessage(String key, Object[] args) {
        return Try.ofSupplier(() -> messageSource.getMessage(key, args, new Locale("vi")));
    }

    @Override
    public Try<String> getMessage(String key, Object[] args, Locale locale) {
        return Try.ofSupplier(() ->messageSource.getMessage(key, args, locale));
    }
}
