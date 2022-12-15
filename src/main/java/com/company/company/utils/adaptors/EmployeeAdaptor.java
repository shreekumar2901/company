package com.company.company.utils.adaptors;

import com.company.company.dto.EmployeeDTO;
import com.company.company.entity.EmployeeEntity;

public class EmployeeAdaptor {

    public EmployeeDTO toDTO(EmployeeEntity entity) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setID(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAddress(entity.getAddress());

        return dto;
    }

    public EmployeeEntity toEntity(EmployeeDTO dto) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(dto.getID());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());

        return entity;
    }
}
