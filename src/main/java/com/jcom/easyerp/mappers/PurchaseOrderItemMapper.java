package com.jcom.easyerp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.jcom.easyerp.dtos.PurchaseOrderItemDto;
import com.jcom.easyerp.entities.PurchaseOrderItem;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface PurchaseOrderItemMapper {

    @Mapping(source = "uid", target = "id")
    @Mapping(source = "product.uid", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    public PurchaseOrderItemDto toDto(PurchaseOrderItem purchaseOrderItem);

    @Mapping(source = "id", target = "uid")
    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "product")
    @Mapping(ignore = true, target = "purchaseOrder")
    public PurchaseOrderItem toEntity(PurchaseOrderItemDto purchaseOrderItemDto);
}
