package com.springboot.transaction.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Data
public class TransactionResponseDTO {
    private Long userId;

    private Long productId;

    private Integer quantity;

    private Double totalPrice;

    private LocalDateTime transactionDate;

    private String status;

    private String paymentMethod;

    private String shippingAddress;

    private String trackingNumber;
}
