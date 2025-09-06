package com.jcom.easyerp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.jcom.easyerp.dtos.SupplierDto;
import com.jcom.easyerp.entities.Supplier;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SupplierMapper {
    
    @Mapping(source = "uid", target = "id")
    public SupplierDto toDto(Supplier supplier);

    @Mapping(source = "id", target = "uid")
    @Mapping(ignore = true, target = "id")
    public Supplier toEntity(SupplierDto supplierDto);

}
