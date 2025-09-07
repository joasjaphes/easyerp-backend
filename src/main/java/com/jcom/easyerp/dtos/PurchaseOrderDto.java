package com.jcom.easyerp.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PurchaseOrderDto {
    private String id;
    private String orderNumber;
    private String supplierId;
    private List<PurchaseOrderItemDto> items;
}
