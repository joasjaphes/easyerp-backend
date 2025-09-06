package com.jcom.easyerp.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcom.easyerp.dtos.ProductDto;
import com.jcom.easyerp.entities.Product;
import com.jcom.easyerp.mappers.ProductMapper;
import com.jcom.easyerp.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    private ProductMapper productMapper;


    @PostMapping("")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product createdProduct = this.productService.createProduct(product);
        return productMapper.toDto(createdProduct);
    }

    @GetMapping("")
    public List<ProductDto> getAllProducts() {
        List<Product> products =  this.productService.getAllProducts();
        return products.stream().map(productMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Integer id) {
        Product product =  this.productService.getProductById(id);
        if(product == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(productMapper.toDto(product));
    }
}
