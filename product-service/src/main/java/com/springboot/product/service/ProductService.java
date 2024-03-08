package com.springboot.product.service;

import com.springboot.product.dto.response.ProductResponseDTO;
import com.springboot.product.entity.Product;
import com.springboot.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Leonardo Siagian
 * Created on 07/03/2024
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<Product> findProductByName(String name) {
        Iterable<Product> productIterable = productRepository.findProductByName(name);
        List<Product> productList = new ArrayList<>();
        productIterable.forEach(productList::add);
        return productList;
    }

    public ProductResponseDTO findProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (Objects.nonNull(product)) {
            return modelMapper.map(product, ProductResponseDTO.class);
        }
        return null;
    }

//    public List<ProductResponseDTO> getAllProduct() {
//        Iterable<Product> productsIterable = productRepository.findAll();
//        List<Product> productsList = new ArrayList<>();
//        productsIterable.forEach(productsList::add);
//        return productsList.stream().map(data -> modelMapper.map(data, ProductResponseDTO.class)).collect(Collectors.toList());
//    }
//
//    public ProductResponseDTO getProductById(Long id) {
//        Product product = productRepository.findById(id).orElse(null);
//        if (Objects.nonNull(product)) {
//            return modelMapper.map(product, ProductResponseDTO.class);
//        }
//        return null;
//    }
//
//    public ProductResponseDTO saveProduct(ProductRequestDTO requestDTO) {
//        Product product = modelMapper.map(requestDTO, Product.class);
//        product = productRepository.save(product);
//        return modelMapper.map(product, ProductResponseDTO.class);
//    }
//
//    public ProductResponseDTO updateProduct(Long id, ProductUpdateRequestDTO requestDTO) {
//        Product productExisting = productRepository.findById(id).orElse(null);
//        if (Objects.isNull(productExisting)) {
//            return null;
//        }
//        PropertyCopyUtil.copyNonNullProperties(requestDTO, productExisting);
//        Product updateProduct = productRepository.save(productExisting);
//        return modelMapper.map(updateProduct, ProductResponseDTO.class);
//    }
//
//    public void deleteProduct(Long id) {
//        Product productExisting = productRepository.findById(id).orElse(null);
//        if (Objects.isNull(productExisting)) {
//            return;
//        }
//        productRepository.deleteById(id);
//    }
}
