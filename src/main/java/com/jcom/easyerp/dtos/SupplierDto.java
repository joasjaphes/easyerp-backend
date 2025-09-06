package com.jcom.easyerp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SupplierDto {

    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
    
}
