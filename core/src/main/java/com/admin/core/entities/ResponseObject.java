package com.admin.core.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Map;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseObject<T> {

    T data;
    Integer code;
    String message;
    Map<String, String> errors;

    public static final String MESSAGE_SUCCESS = "Success";

    public static <T> ResponseObject<T> of(T data) {
        return new ResponseObject<>(data, 200, MESSAGE_SUCCESS, Map.of());
    }

    public static <T> ResponseObject<T> error(Integer code, String message) {
        return new ResponseObject<>(null, code, message, Map.of());
    }

    public static <T> ResponseObject<T> error(Integer code, String message, Map<String, String> errors) {
        return new ResponseObject<>(null, code, message, errors);
    }
}
