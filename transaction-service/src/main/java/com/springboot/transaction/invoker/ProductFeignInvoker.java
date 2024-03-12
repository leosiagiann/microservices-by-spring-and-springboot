package com.springboot.transaction.invoker;

import com.springboot.product.feign.ProductServiceFeignClient;
import com.springboot.product.feign.dto.response.ProductResponseDTO;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: Leonardo Siagian
 * Created on 10/03/2024
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class ProductFeignInvoker {
    private final ProductServiceFeignClient productServiceFeignClient;

    public ProductResponseDTO findProductById(Long productId) {
        try {
            final ResponseEntity<ProductResponseDTO> response = productServiceFeignClient.findProductById(productId);
            if (response.getStatusCode().is2xxSuccessful()) {
                final ProductResponseDTO productResponse = response.getBody();
                if (Objects.nonNull(productResponse)) {
                    return response.getBody();
                }
            }
            log.error("ProductServiceFeignClient::findProductById response error, details {}", response);
        } catch (Exception e) {
            log.error("ProductServiceFeignClient::findProductById feign error, details");
            throw e;
        }
        return null;
    }
}
