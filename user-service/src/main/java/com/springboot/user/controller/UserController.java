package com.springboot.user.controller;

import com.springboot.product.feign.ProductServiceFeignClient;
import com.springboot.transaction.feign.TransactionServiceFeignClient;
import com.springboot.transaction.feign.dto.response.TransactionResponseDTO;
import com.springboot.user.dto.request.UserRequestDTO;
import com.springboot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @Author: Leonardo Siagian
 * Created on 07/03/2024
 */
@RestController
@RequestMapping("/users/user")
@RequiredArgsConstructor
public class UserController {
    // Contoh pemanggilan feign
    private final ProductServiceFeignClient productServiceFeignClient;
    private final TransactionServiceFeignClient transactionServiceFeignClient;
    private final UserService userService;
    @GetMapping
    public String getProducts() {
        // GET Product by FEIGN
        return Objects.requireNonNull(productServiceFeignClient.findProductByName("canon").getBody()).get(0).getName();
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<TransactionResponseDTO>> getUserTransactions(@PathVariable("id") Long id) {
        List<TransactionResponseDTO> transactionResponse = transactionServiceFeignClient.getTransactionUsers(id).getBody();
        return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Validated UserRequestDTO requestDTO) {
        userService.register(requestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
