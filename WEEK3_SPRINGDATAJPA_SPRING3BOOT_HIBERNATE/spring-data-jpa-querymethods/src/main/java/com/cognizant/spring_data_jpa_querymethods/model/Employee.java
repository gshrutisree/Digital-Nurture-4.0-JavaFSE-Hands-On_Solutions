package com.cognizant.spring_data_jpa_querymethods.model;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private double salary;
    @Column
    private boolean permanent;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToMany
    @JoinTable(name = "employee_skill",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skillList;
    public Employee() {}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public boolean isPermanent() {
        return permanent;
    }
    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public List<Skill> getSkillList() {
        return skillList;
    }
    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }
}
