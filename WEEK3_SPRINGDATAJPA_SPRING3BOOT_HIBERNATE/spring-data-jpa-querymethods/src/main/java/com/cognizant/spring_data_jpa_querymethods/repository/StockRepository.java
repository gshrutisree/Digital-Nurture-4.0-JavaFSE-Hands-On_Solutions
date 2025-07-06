package com.cognizant.spring_data_jpa_querymethods.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring_data_jpa_querymethods.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByCodeAndDateBetween(String code, LocalDate start, LocalDate end);

    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal price);

    List<Stock> findTop3ByOrderByVolumeDesc();

    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
