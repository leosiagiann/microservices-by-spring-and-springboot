package com.springboot.transaction.controller;

import com.springboot.transaction.dto.request.TransactionRequestDTO;
import com.springboot.transaction.dto.response.TransactionResponseDTO;
import com.springboot.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@RestController
@RequestMapping("/transactions/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody @Validated TransactionRequestDTO transactionRequestDTO) {
        TransactionResponseDTO responseDTO = transactionService.createTransaction(transactionRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<TransactionResponseDTO>> getTransactionUsers(@PathVariable("id") Long userId) {
        List<TransactionResponseDTO> responseDTO = transactionService.getTransactionUsers(userId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
