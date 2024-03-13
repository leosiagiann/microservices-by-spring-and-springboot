package com.springboot.transaction.dto.request;

import com.springboot.transaction.validator.constraint.ProductMustExists;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Data
public class TransactionRequestDTO {
    @NotNull
    private Long userId;

    @ProductMustExists
    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;

    @NotNull
    private String paymentMethod;

    @NotNull
    private String shippingAddress;
}
