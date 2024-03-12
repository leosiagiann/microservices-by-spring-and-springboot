package com.springboot.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Leonardo Siagian
 * Created on 12/03/2024
 */
@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private String code;
    @JsonProperty("msg")
    private String message;
}
