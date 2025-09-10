package com.jcom.easyerp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jcom.easyerp.entities.Product;
import com.jcom.easyerp.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

    public Product getProductById(Integer id) {
        return this.productRepository.findById(id).orElse(null);
    }

    public Product getProductByUid(String uid) {
        return this.productRepository.findByUid(uid);
    }

    public Product updateProduct(Integer id, Product product) {
        if (this.productRepository.existsById(id)) {
            return this.productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Integer id) {
        if (this.productRepository.existsById(id)) {
            this.productRepository.deleteById(id);
        }
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
}
