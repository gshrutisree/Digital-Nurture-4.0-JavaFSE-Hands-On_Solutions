package com.cognizant.spring_data_jpa_querymethods.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring_data_jpa_querymethods.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

