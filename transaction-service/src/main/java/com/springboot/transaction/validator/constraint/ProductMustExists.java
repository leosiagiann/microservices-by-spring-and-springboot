package com.springboot.transaction.validator.constraint;

import com.springboot.transaction.constant.ErrorConstant;
import com.springboot.transaction.validator.ProductMustExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @Author: Leonardo Siagian
 * Created on 12/03/2024
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductMustExistsValidator.class)
@Documented
public @interface ProductMustExists {
    String message() default ErrorConstant.PRODUCT_NOT_EXISTS;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
