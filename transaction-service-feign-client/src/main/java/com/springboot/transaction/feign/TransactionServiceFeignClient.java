package com.springboot.transaction.feign;

import com.springboot.transaction.feign.dto.response.TransactionResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@FeignClient(name = "transaction-service")
public interface TransactionServiceFeignClient {
    @GetMapping("/api/transactions/transaction/user/{id}")
    ResponseEntity<List<TransactionResponseDTO>> getTransactionUsers(@PathVariable("id") Long userId);
}
