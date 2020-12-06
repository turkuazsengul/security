package com.okay.security.converter;

import com.okay.security.core.AbstractBaseConverter;
import com.okay.security.entity.User;
import com.okay.security.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractBaseConverter<UserDto, User> {

    @Override
    protected void doConvertToDto(UserDto dto, User entity) {
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setUsername(entity.getUsername());
    }

    @Override
    protected void doConvertToEntity(User entity, UserDto dto) {
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
    }
}