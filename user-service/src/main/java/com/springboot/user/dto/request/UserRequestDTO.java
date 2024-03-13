package com.springboot.user.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author: Leonardo Siagian
 * Created on 13/03/2024
 */
@Data
public class UserRequestDTO {
    @NotNull
    private String name;

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private Integer age;
}
