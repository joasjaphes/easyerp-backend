package com.jcom.easyerp.mappers;

import com.jcom.easyerp.dtos.UserDto;
import com.jcom.easyerp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;



@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(source = "uid", target = "id")
    @Mapping(ignore = true, target = "password")
    public UserDto toDto(User user);

    @Mapping(source = "id", target = "uid")
    @Mapping(ignore = true, target = "id")
    public User toEntity(UserDto userDto);
    
}
