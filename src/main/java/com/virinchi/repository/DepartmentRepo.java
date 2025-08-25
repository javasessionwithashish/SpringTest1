package com.virinchi.repository;

import com.virinchi.model.Address;
import com.virinchi.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
