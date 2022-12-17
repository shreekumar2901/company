package com.company.company.utils.adaptors;

import com.company.company.dto.DepartmentDTO;
import com.company.company.entity.DepartmentEntity;

public class DepartmentAdaptor {

    public DepartmentDTO toDTO(DepartmentEntity entity) {
        DepartmentDTO dto = new DepartmentDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    public DepartmentEntity toEntity(DepartmentDTO dto) {
        DepartmentEntity entity = new DepartmentEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }
}
