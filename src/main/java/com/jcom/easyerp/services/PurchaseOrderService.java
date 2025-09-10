package com.jcom.easyerp.services;


import org.springframework.stereotype.Service;

import com.jcom.easyerp.dtos.PurchaseOrderDto;
import com.jcom.easyerp.dtos.PurchaseOrderItemDto;
import com.jcom.easyerp.entities.Product;
import com.jcom.easyerp.entities.PurchaseOrder;
import com.jcom.easyerp.entities.PurchaseOrderItem;
import com.jcom.easyerp.entities.Supplier;
import com.jcom.easyerp.mappers.PurchaseOrderItemMapper;
import com.jcom.easyerp.mappers.PurchaseOrderMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PurchaseOrderService {

    private EntityManager entityManager;
    private SupplierService supplierService;
    private PurchaseOrderMapper purchaseOrderMapper;
    private PurchaseOrderItemMapper purchaseOrderMapperItem;
    private ProductService productService;

    public PurchaseOrder createPurchaseOrder(PurchaseOrderDto purchaseOrderDto) {
        // Implementation for creating a purchase order
        EntityTransaction transaction = this.entityManager.getTransaction();
        try {
            transaction.begin();
            Supplier supplier = this.supplierService.getSupplierByUid(purchaseOrderDto.getSupplierId());
            PurchaseOrder purchaseOrder = this.purchaseOrderMapper.toEntity(purchaseOrderDto);
            purchaseOrder.setSupplier(supplier);
            this.entityManager.persist(purchaseOrder);
            for(PurchaseOrderItemDto itemDto : purchaseOrderDto.getItems()) {
                PurchaseOrderItem item = this.purchaseOrderMapperItem.toEntity(itemDto);
                Product itemProduct = this.productService.getProductByUid(itemDto.getProductId());
                item.setPurchaseOrder(purchaseOrder);
                item.setProduct(itemProduct);
                this.entityManager.persist(item);
            }
            transaction.commit();
            return purchaseOrder;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
}
