package com.okay.security.converter;

import com.okay.security.core.AbstractBaseConverter;
import com.okay.security.entity.User;
import com.okay.security.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractBaseConverter<UserDto, User> {

    @Autowired
    private RoleConverter roleConverter;

    @Override
    protected void doConvertToDto(UserDto dto, User entity) {
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRoleList(roleConverter.convertToDtoList(entity.getRoleList()));
    }

    @Override
    protected void doConvertToEntity(User entity, UserDto dto) {
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setRoleList(roleConverter.convertToEntityList(dto.getRoleList()));
    }
}