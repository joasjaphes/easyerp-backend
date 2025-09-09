package com.jcom.easyerp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.jcom.easyerp.dtos.PurchaseOrderDto;
import com.jcom.easyerp.entities.PurchaseOrder;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PurchaseOrderMapper {

    @Mapping(source = "uid", target = "id")
    @Mapping(source = "supplier.uid", target = "supplierId")
    @Mapping(ignore = true, target = "items")
    public PurchaseOrderDto toDto(PurchaseOrder purchaseOrder);

    @Mapping(source = "id", target = "uid")
    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "items")
    @Mapping(ignore = true, target = "supplier")
    public PurchaseOrder toEntity(PurchaseOrderDto purchaseOrderDto);
}
