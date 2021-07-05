package com.home.service.impl;

import com.home.Html;
import com.home.dto.PageDto;
import com.home.entity.Page;
import com.home.entity.Statistics;
import com.home.repository.PageRepository;
import com.home.repository.StatisticsRepository;
import com.home.service.PageService;
import com.home.service.converter.PageConverter;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PageServiceImpl implements PageService {

    public static final Logger logger = LoggerFactory.getLogger(PageServiceImpl.class);

    private final PageRepository pageRepository;
    private final PageConverter pageConverter;
    private final StatisticsRepository statisticsRepository;

    public PageServiceImpl(PageRepository pageRepository, PageConverter pageConverter, StatisticsRepository statisticsRepository) {
        this.pageRepository = pageRepository;
        this.pageConverter = pageConverter;
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public PageDto saveAndParse(PageDto pageDto) {
        Html html = null;
        try {
            html = new Html(Jsoup.connect(pageDto.getLink()).get());
        } catch (IOException e) {
            logger.error("saveAndParse(" + pageDto.getLink() + "). Страница не получена:" + e.getMessage());
            return null;
        }
        html.saveToFile();
        Map<String, Integer> map = html.uniqueWords();

        Page page = pageRepository.save(pageConverter.fromPageDtoToPage(pageDto));
        List<Statistics> result = new ArrayList<>();
        for(Map.Entry<String, Integer> m : map.entrySet()) {
            result.add(new Statistics.Builder()
                    .setPageId(page.getId())
                    .setName(m.getKey())
                    .setCount(m.getValue())
                    .build());
        }
        statisticsRepository.saveAll(result);
        return pageConverter.fromPageToPageDto(page);
    }

    @Override
    public List<PageDto> findAll() {
        List<Page> list = pageRepository.findAll();
        List<PageDto> result = new ArrayList<>();
        for (Page page : list) {
            result.add(pageConverter.fromPageToPageDto(page));
        }
        return result;
    }
}