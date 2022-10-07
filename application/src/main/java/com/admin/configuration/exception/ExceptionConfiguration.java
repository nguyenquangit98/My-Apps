package com.admin.configuration.exception;

import com.admin.exception.MessageService;
import com.admin.exception.impl.MessageServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionConfiguration {
    @Bean
    public MessageService messageService(MessageSource messageSource){
        return new MessageServiceImpl(messageSource);
    }
}
