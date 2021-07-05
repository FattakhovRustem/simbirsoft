package com.home.service.converter;


import com.home.dto.StatisticsDto;
import com.home.entity.Statistics;
import org.springframework.stereotype.Component;

@Component
public class StatisticsConverter {

    public Statistics fromStatisticsDtoToStatistics(StatisticsDto statisticsDto) {
        return new Statistics.Builder()
                .setId(statisticsDto.getId())
                .setPageId(statisticsDto.getPageId())
                .setName(statisticsDto.getName())
                .setCount(statisticsDto.getCount())
                .build();
    }

    public StatisticsDto fromStatisticsToStatisticsDto(Statistics statistics) {
        return new StatisticsDto.Builder()
                .setId(statistics.getId())
                .setPageId(statistics.getPageId())
                .setName(statistics.getName())
                .setCount(statistics.getCount())
                .build();
    }
}