package com.springboot.product.repository;

import com.springboot.product.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @Author: Leonardo Siagian
 * Created on 07/03/2024
 */
@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findProductByName(String name);
}
