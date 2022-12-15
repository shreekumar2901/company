package com.company.company.controller;


import com.company.company.dto.EmployeeDTO;
import com.company.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public List<EmployeeDTO> getEmployees() {

        return employeeService.getAllEmployees();
    }

    @PostMapping("/")
    public

}
