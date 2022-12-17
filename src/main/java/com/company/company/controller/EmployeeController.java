package com.company.company.controller;


import com.company.company.dto.EmployeeDTO;
import com.company.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {

        List<EmployeeDTO> dtos = employeeService.getAllEmployees();
        return new ResponseEntity<List<EmployeeDTO>>(dtos, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> postEmployee(@RequestBody EmployeeDTO dto) {
        String response = employeeService.postEmployee(dto);

        // TODO: have to implement controlleradvice for error handling
        if (response.toLowerCase().contains("success"))
            return new ResponseEntity<String>(response, HttpStatus.CREATED);
        return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
