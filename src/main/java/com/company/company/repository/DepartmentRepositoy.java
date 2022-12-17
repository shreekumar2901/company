package com.company.company.repository;

import com.company.company.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepositoy extends JpaRepository<DepartmentEntity, String> {

}
