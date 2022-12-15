package com.company.company.service;


import com.company.company.dto.EmployeeDTO;
import com.company.company.entity.EmployeeEntity;
import com.company.company.repository.EmployeeRepository;
import com.company.company.utils.adaptors.EmployeeAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {



    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> entities = employeeRepository.findAll();

        List<EmployeeDTO> employees = null;

        if(entities != null || entities.size() > 0) {
            employees = new ArrayList<>();

            for(EmployeeEntity entity : entities) {
                EmployeeAdaptor employeeAdaptor = new EmployeeAdaptor();
                employees.add(employeeAdaptor.toDTO(entity));
            }
        }
        return employees;
    }
}
