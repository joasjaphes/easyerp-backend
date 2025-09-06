package com.jcom.easyerp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.jcom.easyerp.dtos.ProductDto;
import com.jcom.easyerp.entities.Product;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    @Mapping(source = "uid", target = "id")
    public ProductDto toDto(Product product);

    @Mapping(source = "id", target = "uid")
    @Mapping(ignore = true, target = "id")
    public Product toEntity(ProductDto productDto);
    
}
