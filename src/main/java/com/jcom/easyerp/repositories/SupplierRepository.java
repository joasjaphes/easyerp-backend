package com.jcom.easyerp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcom.easyerp.entities.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

   Supplier findByUid(String uid);
    
}
