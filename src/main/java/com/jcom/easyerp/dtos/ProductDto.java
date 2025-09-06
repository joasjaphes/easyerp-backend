package com.jcom.easyerp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

    private String id;
    private String name;
    private String description;
    private String unitOfMeasure;
}
