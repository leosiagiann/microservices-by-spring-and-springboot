package com.springboot.product.controller;

import com.springboot.product.dto.response.ProductResponseDTO;
import com.springboot.product.entity.Product;
import com.springboot.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product Controller", description = "The product")
@RestController
@RequestMapping("/products/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @Operation(
            summary = "Get List products",
            description = "get list products by product name"
    )
    public ResponseEntity<List<Product>> findProductByName(@RequestParam String name) {
        List<Product> products = productService.findProductByName(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get products",
            description = "get product by product id"
    )
    public ResponseEntity<ProductResponseDTO> findProductById(@PathVariable("id") Long id) {
        ProductResponseDTO product = productService.findProductById(id);
        return ResponseEntity.ok(product);
    }

//    @GetMapping
//    public ResponseEntity<List<ProductResponseDTO>> getAllProduct() {
//        List<ProductResponseDTO> products = productService.getAllProduct();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") Long id) {
//        ProductResponseDTO responseDTO = productService.getProductById(id);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<ProductResponseDTO> saveProduct(@RequestBody @Validated ProductRequestDTO requestDTO) {
//        ProductResponseDTO responseDTO = productService.saveProduct(requestDTO);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//    @PatchMapping("{id}")
//    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") Long id, @RequestBody ProductUpdateRequestDTO requestDTO) {
//        ProductResponseDTO responseDTO = productService.updateProduct(id, requestDTO);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
//        productService.deleteProduct(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}