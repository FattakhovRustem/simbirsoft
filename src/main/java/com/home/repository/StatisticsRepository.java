package com.home.repository;

import com.home.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
    List<Statistics> findByPageId(Integer pageId);
}