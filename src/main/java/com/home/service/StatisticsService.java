package com.home.service;

import com.home.dto.StatisticsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatisticsService {
    List<StatisticsDto> findAllByPageId(Integer pageId);
}
