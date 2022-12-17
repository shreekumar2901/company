package com.company.company.service;

import com.company.company.dto.DepartmentDTO;
import com.company.company.dto.EmployeeDTO;
import com.company.company.entity.DepartmentEntity;
import com.company.company.repository.DepartmentRepositoy;
import com.company.company.utils.adaptors.DepartmentAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepositoy repositoy;

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> entities = repositoy.findAll();

        List<DepartmentDTO> departments = null;

        if (entities != null && entities.size() > 0) {
            departments = new ArrayList<>();

            for(DepartmentEntity entity: entities) {
                DepartmentAdaptor adaptor = new DepartmentAdaptor();
                departments.add(adaptor.toDTO(entity));
            }
        }

        return departments;
    }
}