package com.cognizant.spring_data_jpa_querymethods.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring_data_jpa_querymethods.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameContainingIgnoreCase(String keyword);

    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String keyword);

    List<Country> findByNameStartingWithIgnoreCase(String prefix);
}
