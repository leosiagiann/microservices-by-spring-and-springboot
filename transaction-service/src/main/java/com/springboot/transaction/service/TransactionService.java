package com.springboot.transaction.service;

import com.springboot.product.feign.dto.response.ProductResponseDTO;
import com.springboot.transaction.dto.request.TransactionRequestDTO;
import com.springboot.transaction.dto.response.TransactionResponseDTO;
import com.springboot.transaction.entity.Transaction;
import com.springboot.transaction.invoker.ProductFeignInvoker;
import com.springboot.transaction.repository.TransactionRepository;
import com.springboot.transaction.service.validation.ProductServiceValidation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.math.NumberUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final ProductServiceValidation productServiceValidation;
    private final ModelMapper modelMapper;
    private final TransactionTemplate transactionTemplate;

    public TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO) {
        AtomicReference<TransactionResponseDTO> atomicReference = new AtomicReference<TransactionResponseDTO>();
        transactionTemplate.execute(status -> {
            Transaction transaction = new Transaction();
            transaction.setUserId(transactionRequestDTO.getUserId());
            transaction.setProductId(transactionRequestDTO.getProductId());
            transaction.setQuantity(transactionRequestDTO.getQuantity());
            transaction.setPaymentMethod(transactionRequestDTO.getPaymentMethod());
            transaction.setShippingAddress(transactionRequestDTO.getShippingAddress());
            ProductResponseDTO productResponseDTO = productServiceValidation.findByProductId(transaction.getProductId());
            transaction.setTotalPrice(NumberUtils.DOUBLE_ZERO);
            if (Objects.nonNull(productResponseDTO.getPrice())) {
                transaction.setTotalPrice(productResponseDTO.getPrice() * transaction.getQuantity());
            }
            transaction.setTransactionDate(LocalDateTime.now());
            transaction.setStatus("PROCESSING");
            transaction.setTrackingNumber("PROCESSING");
            transaction = transactionRepository.save(transaction);
            atomicReference.set(modelMapper.map(transaction, TransactionResponseDTO.class));
            return Boolean.TRUE;
        });
        return atomicReference.get();
    }


    public List<TransactionResponseDTO> getTransactionUsers(Long userId) {
        List<Transaction> transactions = transactionRepository.findByUserId(userId);
        return transactions.stream().map(data -> modelMapper.map(data, TransactionResponseDTO.class)).collect(Collectors.toList());
    }
}
