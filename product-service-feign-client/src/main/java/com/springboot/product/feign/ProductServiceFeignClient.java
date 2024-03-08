package com.springboot.product.feign;

import com.springboot.product.feign.dto.response.Product;
import com.springboot.product.feign.dto.response.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Leonardo Siagian
 * Created on 07/03/2024
 */
@FeignClient(name = "product-service")
public interface ProductServiceFeignClient {
    @GetMapping("/api/products/product")
    ResponseEntity<List<Product>> findProductByName(@RequestParam String name);

    @GetMapping("/api/products/product/{id}")
    ResponseEntity<ProductResponseDTO> findProductById(@PathVariable("id") Long id);
}
