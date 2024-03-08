package com.springboot.transaction.repository;

import com.springboot.transaction.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@RepositoryRestResource
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long userId);
}
