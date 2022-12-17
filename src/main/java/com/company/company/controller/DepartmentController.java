package com.company.company.controller;

import com.company.company.dto.DepartmentDTO;
import com.company.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return new ResponseEntity<List<DepartmentDTO>>(departments, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> postDepartment(@RequestBody DepartmentDTO dto) {
        String response = departmentService.postDepartments(dto);

        // TODO: have to implement controlleradvice for error handling
        if (response.toLowerCase().contains("success"))
            return new ResponseEntity<String>(response, HttpStatus.CREATED);
        return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}