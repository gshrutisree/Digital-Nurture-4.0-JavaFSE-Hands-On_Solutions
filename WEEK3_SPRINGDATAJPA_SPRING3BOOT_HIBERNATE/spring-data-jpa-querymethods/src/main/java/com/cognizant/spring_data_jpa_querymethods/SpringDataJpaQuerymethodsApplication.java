package com.cognizant.spring_data_jpa_querymethods;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.spring_data_jpa_querymethods.model.Department;
import com.cognizant.spring_data_jpa_querymethods.model.Employee;
import com.cognizant.spring_data_jpa_querymethods.service.DepartmentService;
import com.cognizant.spring_data_jpa_querymethods.service.EmployeeService;

@SpringBootApplication
public class SpringDataJpaQuerymethodsApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataJpaQuerymethodsApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpaQuerymethodsApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);

        // Run only one test at a time if needed
        testAddEmployee();
        testGetDepartment();
    }

    @Override
    public void run(String... args) {
        // no-op
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");

        // Save a new department (or check if already exists if needed)
        Department dept = new Department();
        dept.setName("Engineering");
        departmentService.save(dept); // This ensures a department exists with an ID

        // Create new employee with that department
        Employee emp = new Employee();
        emp.setName("Jane Smith");
        emp.setPermanent(true);
        emp.setSalary(80000);
        emp.setDateOfBirth(new Date());
        emp.setDepartment(dept);

        employeeService.save(emp);

        LOGGER.debug("Employee: {}", emp);
        LOGGER.info("End");
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");

        Employee emp = employeeService.get(1); // Make sure employee with ID 1 exists
        LOGGER.debug("Employee: {}", emp);
        LOGGER.debug("Department: {}", emp.getDepartment());

        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");

        Employee emp = employeeService.get(1);
        Department newDept = new Department();
        newDept.setName("HR");
        departmentService.save(newDept); // Save new department

        emp.setDepartment(newDept);
        employeeService.save(emp);

        LOGGER.debug("Updated Employee: {}", emp);
        LOGGER.info("End");
    }

    private static void testGetDepartment() {
        LOGGER.info("Start");

        Department dept = departmentService.get(1); // Make sure ID 1 exists (created earlier)

        LOGGER.debug("Department: {}", dept);
        LOGGER.debug("Employees: {}", dept.getEmployeeList());

        LOGGER.info("End");
    }
}
