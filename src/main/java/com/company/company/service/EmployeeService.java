package com.company.company.service;


import com.company.company.dto.EmployeeDTO;
import com.company.company.entity.EmployeeEntity;
import com.company.company.repository.EmployeeRepository;
import com.company.company.utils.adaptors.EmployeeAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {



    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> entities = employeeRepository.findAll();

        List<EmployeeDTO> employees = null;

        if(entities != null && entities.size() > 0) {
            employees = new ArrayList<>();

            for(EmployeeEntity entity : entities) {
                EmployeeAdaptor employeeAdaptor = new EmployeeAdaptor();
                employees.add(employeeAdaptor.toDTO(entity));
            }
        }
        return employees;
    }

    private EmployeeDTO findEmployeeById(int id) {
        Optional<EmployeeEntity> entity = employeeRepository.findById(id);
        if (entity.isEmpty())
            return null;
        EmployeeAdaptor adaptor = new EmployeeAdaptor();
        return(adaptor.toDTO(entity.get()));

    }

    public String postEmployee(EmployeeDTO dto) {
        EmployeeAdaptor employeeAdaptor = new EmployeeAdaptor();
        EmployeeEntity employeeEntity = employeeAdaptor.toEntity(dto);

        try {
            employeeRepository.save(employeeEntity);
            return "Saved Successfully";
        } catch(Exception e) {
            e.printStackTrace();
            return "Some error occurred while saving. Please try again.";
        }
    }


}
