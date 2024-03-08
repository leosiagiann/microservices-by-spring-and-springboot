package com.springboot.product.dto.response;

import lombok.Data;

/**
 * @Author: Leonardo Siagian
 * Created on 07/03/2024
 */
@Data
public class ProductResponseDTO {
    private String name;

    private Integer stock;

    private Double price;

    private String description;
}
