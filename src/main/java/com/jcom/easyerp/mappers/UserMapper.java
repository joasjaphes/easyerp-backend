package com.jcom.easyerp.mappers;

import com.jcom.easyerp.dtos.UserDto;
import com.jcom.easyerp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "uid", target = "id")
    public UserDto toDto(User user);

    @Mapping(source = "id", target = "uid")
    public User toEntity(UserDto userDto);
    
}
