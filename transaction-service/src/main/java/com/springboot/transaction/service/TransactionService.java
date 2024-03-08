package com.springboot.transaction.service;

import com.springboot.product.feign.ProductServiceFeignClient;
import com.springboot.product.feign.dto.response.ProductResponseDTO;
import com.springboot.transaction.configuration.MapperConfig;
import com.springboot.transaction.dto.request.TransactionRequestDTO;
import com.springboot.transaction.dto.response.TransactionResponseDTO;
import com.springboot.transaction.entity.Transaction;
import com.springboot.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final ProductServiceFeignClient productServiceFeignClient;
    private final ModelMapper modelMapper;

    public TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = new Transaction();
        transaction.setUserId(transactionRequestDTO.getUserId());
        transaction.setProductId(transactionRequestDTO.getProductId());
        transaction.setQuantity(transactionRequestDTO.getQuantity());
        transaction.setPaymentMethod(transactionRequestDTO.getPaymentMethod());
        transaction.setShippingAddress(transactionRequestDTO.getShippingAddress());
        String name = productServiceFeignClient.findProductByName("canon").getBody().get(0).getName();
        ProductResponseDTO productResponseDTO = productServiceFeignClient.findProductById(1L).getBody();
        transaction.setTotalPrice(0D);
        if (Objects.nonNull(productResponseDTO)) {
            transaction.setTotalPrice(productResponseDTO.getPrice() * transaction.getQuantity());
        }
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setStatus("PROCESSING");
        transaction.setTrackingNumber("PROCESSING");
        transaction = transactionRepository.save(transaction);
        TransactionResponseDTO responseDTO = modelMapper.map(transaction, TransactionResponseDTO.class);
        return responseDTO;
    }


    public List<TransactionResponseDTO> getTransactionUsers(Long userId) {
        List<Transaction> transactions = transactionRepository.findByUserId(userId);
        return transactions.stream().map(data -> modelMapper.map(data, TransactionResponseDTO.class)).collect(Collectors.toList());
    }
}
