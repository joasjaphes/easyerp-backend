package com.jcom.easyerp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jcom.easyerp.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByUid(String uid);
}
