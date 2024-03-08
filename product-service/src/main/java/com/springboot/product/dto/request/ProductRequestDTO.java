package com.springboot.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Data
public class ProductRequestDTO {
    @NotNull
    @NotBlank
    private String merk;

    @NotNull
    private Integer stock;

    @NotNull
    private Double price;

    private String description;
}
