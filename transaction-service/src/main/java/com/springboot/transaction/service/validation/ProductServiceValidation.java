package com.springboot.transaction.service.validation;

import com.springboot.product.feign.dto.response.ProductResponseDTO;
import com.springboot.transaction.constant.ErrorConstant;
import com.springboot.transaction.exception.CustomException;
import com.springboot.transaction.invoker.ProductFeignInvoker;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: Leonardo Siagian
 * Created on 12/03/2024
 */
@Service
@RefreshScope
@RequiredArgsConstructor
public class ProductServiceValidation {
    private ProductResponseDTO product;

    private final ProductFeignInvoker productFeignInvoker;

    public ProductResponseDTO findByProductId(Long id) {
        if (Objects.isNull(product)) {
            product = productFeignInvoker.findProductById(id);
            if (Objects.isNull(product)) {
                throw new CustomException(ErrorConstant.PRODUCT_NOT_EXISTS);
            }
        }
        return product;
    }
}
