package com.okay.security.converter;

import com.okay.security.core.AbstractBaseConverter;
import com.okay.security.entity.Role;
import com.okay.security.model.RoleDto;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter extends AbstractBaseConverter<RoleDto, Role> {

    @Override
    protected void doConvertToDto(RoleDto dto, Role entity) {
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
    }

    @Override
    protected void doConvertToEntity(Role entity, RoleDto dto) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
    }
}