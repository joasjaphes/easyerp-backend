package com.jcom.easyerp.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcom.easyerp.dtos.SupplierDto;
import com.jcom.easyerp.entities.Supplier;
import com.jcom.easyerp.mappers.SupplierMapper;
import com.jcom.easyerp.services.SupplierService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private SupplierService supplierService;
    private SupplierMapper supplierMapper;

    @PostMapping("")
    public SupplierDto createSupplier(@RequestBody SupplierDto supplierDto) {
        Supplier supplier = supplierMapper.toEntity(supplierDto);
        Supplier createdSupplier = this.supplierService.createSupplier(supplier);
        return supplierMapper.toDto(createdSupplier);
    }

    @GetMapping("")
    public List<SupplierDto> getSuppliers() {
        List<Supplier> suppliers = this.supplierService.getAllSuppliers();

        return suppliers.stream().map(supplierMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable("id") Integer id) {
        Supplier supplier = this.supplierService.getSupplierById(id);
          if(supplier == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(supplierMapper.toDto(supplier));
    }
    
}
