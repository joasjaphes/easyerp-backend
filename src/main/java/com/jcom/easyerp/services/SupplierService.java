package com.jcom.easyerp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jcom.easyerp.entities.Supplier;
import com.jcom.easyerp.repositories.SupplierRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SupplierService {
    private SupplierRepository supplierRepository;

    public Supplier createSupplier(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }

    public Supplier getSupplierById(Integer id) {
        return this.supplierRepository.findById(id).orElse(null);
    }

    public Supplier updateSupplier(Integer id, Supplier supplier) {
        if (this.supplierRepository.existsById(id)) {
            return this.supplierRepository.save(supplier);
        }
        return null;
    }

    public void deleteSupplier(Integer id) {
        if (this.supplierRepository.existsById(id)) {
            this.supplierRepository.deleteById(id);
        }
    }

    public List<Supplier> getAllSuppliers() {
        return this.supplierRepository.findAll();
    }

}
