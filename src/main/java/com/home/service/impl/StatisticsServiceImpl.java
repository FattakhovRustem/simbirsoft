package com.home.service.impl;

import com.home.dto.StatisticsDto;
import com.home.entity.Statistics;
import com.home.repository.StatisticsRepository;
import com.home.service.StatisticsService;
import com.home.service.converter.StatisticsConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsRepository statisticsRepository;
    private final StatisticsConverter statisticsConverter;

    public StatisticsServiceImpl(StatisticsRepository statisticsRepository, StatisticsConverter statisticsConverter) {
        this.statisticsRepository = statisticsRepository;
        this.statisticsConverter = statisticsConverter;
    }

    @Override
    public List<StatisticsDto> findAllByPageId(Integer pageId) {
        List<Statistics> list = statisticsRepository.findByPageId(pageId);
        List<StatisticsDto> result = new ArrayList<>();
        for (Statistics statistics : list) {
            result.add(statisticsConverter.fromStatisticsToStatisticsDto(statistics));
        }
        return result;
    }

}