package com.springboot.user.validator.constraint;

import com.springboot.user.constant.ErrorConstant;
import com.springboot.user.validator.UsernameMustExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @Author: Leonardo Siagian
 * Created on 14/03/2024
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameMustExistsValidator.class)
@Documented
public @interface UsernameMustExists {
    String message() default ErrorConstant.USERNAME_NOT_EXISTS;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
