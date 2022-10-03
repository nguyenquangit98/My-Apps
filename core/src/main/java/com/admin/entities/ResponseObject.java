package com.admin.entities;

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
    String message;
    Map<String, String> errors;

    public static <T> ResponseObject<T> of(T data) {
        return new ResponseObject<>(data,"success", Map.of());
    }

    public static <T> ResponseObject<T> error(String message) {
        return new ResponseObject<>(null, message, Map.of());
    }

    public static <T> ResponseObject<T> error(String message, Map<String, String> errors) {
        return new ResponseObject<>(null, message, errors);
    }
}
