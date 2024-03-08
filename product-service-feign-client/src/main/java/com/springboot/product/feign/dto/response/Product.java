package com.springboot.product.feign.dto.response;

import lombok.Data;

/**
 * @Author: Leonardo Siagian
 * Created on 07/03/2024
 */
@Data
public class Product {
    private Long id;

    private String name;

    private Double price;

    private String description;
}
