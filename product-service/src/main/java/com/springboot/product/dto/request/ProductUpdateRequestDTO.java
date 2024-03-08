package com.springboot.product.dto.request;

import lombok.Data;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Data
public class ProductUpdateRequestDTO {
    private String merk;

    private Integer stock;

    private Double price;

    private String description;
}
