package com.springboot.transaction.validator;

import com.springboot.product.feign.dto.response.ProductResponseDTO;
import com.springboot.transaction.exception.CustomException;
import com.springboot.transaction.service.validation.ProductServiceValidation;
import com.springboot.transaction.validator.constraint.ProductMustExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * @Author: Leonardo Siagian
 * Created on 12/03/2024
 */
@RequiredArgsConstructor
public class ProductMustExistsValidator implements ConstraintValidator<ProductMustExists, Long> {
    private final ProductServiceValidation productServiceValidation;
    @Override
    public boolean isValid(Long productId, ConstraintValidatorContext constraintValidatorContext) {
        try {
            ProductResponseDTO responseDTO = productServiceValidation.findByProductId(productId);
        } catch (CustomException ex) {
            return false;
        }
        return true;
    }
}
