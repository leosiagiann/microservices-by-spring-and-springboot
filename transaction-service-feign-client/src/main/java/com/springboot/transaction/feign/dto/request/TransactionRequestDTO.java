package com.springboot.transaction.feign.dto.request;

import lombok.Data;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Data
public class TransactionRequestDTO {
    private Long userId;

    private Long productId;

    private Integer quantity;

    private String paymentMethod;

    private String shippingAddress;
}
