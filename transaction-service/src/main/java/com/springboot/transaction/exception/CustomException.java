package com.springboot.transaction.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: Leonardo Siagian
 * Created on 12/03/2024
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private String code;
    private Object additionalValue;
    @JsonProperty("msg")
    private String message;

    public CustomException(String code) {
        super(code);
        this.code = code;
    }

    public CustomException(String code, Object additionalValue) {
        super(code);
        this.code = code;
        this.additionalValue = additionalValue;
    }
}
