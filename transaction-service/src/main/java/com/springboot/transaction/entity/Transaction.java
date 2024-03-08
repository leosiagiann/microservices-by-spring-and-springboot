package com.springboot.transaction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
