package com.cognizant.spring_data_jpa_querymethods.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.spring_data_jpa_querymethods.model.Department;
import com.cognizant.spring_data_jpa_querymethods.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department get(int id) {
        LOGGER.info("Start");
        return departmentRepository.findById(id).get();
    }

    @Transactional
    public void save(Department department) {
        LOGGER.info("Start");
        departmentRepository.save(department);
        LOGGER.info("End");
    }
}
