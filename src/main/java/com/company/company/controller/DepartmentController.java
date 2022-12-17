package com.company.company.controller;

import com.company.company.dto.DepartmentDTO;
import com.company.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {


    }
}
