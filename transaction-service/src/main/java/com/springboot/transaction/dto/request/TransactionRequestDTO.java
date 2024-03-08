package com.springboot.transaction.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Data
public class TransactionRequestDTO {
    @NotNull
    private Long userId;

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;

    @NotNull
    private String paymentMethod;

    @NotNull
    private String shippingAddress;
}
