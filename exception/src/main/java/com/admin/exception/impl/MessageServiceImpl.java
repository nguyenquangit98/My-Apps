package com.admin.exception.impl;

import com.admin.exception.MessageService;
import org.springframework.context.MessageSource;

import java.util.Locale;

public record MessageServiceImpl(MessageSource messageSource) implements MessageService {

    @Override
    public String getMessage(String key, Object[] args) {
        return messageSource.getMessage(key, args, new Locale("vi"));
    }

    @Override
    public String getMessage(String key, Object[] args, Locale locale) {
        return messageSource.getMessage(key, args, locale);
    }
}
