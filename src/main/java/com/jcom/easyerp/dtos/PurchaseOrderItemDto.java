package com.jcom.easyerp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PurchaseOrderItemDto {

    private String id;
    private String productId;
    private String productName;
    private double quantity;
    private double unitPrice;
}
