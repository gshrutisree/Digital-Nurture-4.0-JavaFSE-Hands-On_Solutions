package com.cognizant.spring_data_jpa_querymethods.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring_data_jpa_querymethods.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}