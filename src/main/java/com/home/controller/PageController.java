package com.home.controller;

import com.home.dto.PageDto;
import com.home.dto.StatisticsDto;
import com.home.service.PageService;
import com.home.service.StatisticsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/page")
public class PageController {
    private final PageService pageService;
    private final StatisticsService statisticsService;

    public PageController(PageService pageService, StatisticsService statisticsService) {
        this.pageService = pageService;
        this.statisticsService = statisticsService;
    }

    @PostMapping("/saveAndParse")
    public PageDto saveAndParse(@RequestBody PageDto pageDto) {
        return pageService.saveAndParse(pageDto);
    }

    @GetMapping("/findAll")
    public List<PageDto> findAll() {
        return pageService.findAll();
    }

    @GetMapping("/{pageId}/statistics")
    public List<StatisticsDto> findAllByPageId(@PathVariable Integer pageId) {
        return statisticsService.findAllByPageId(pageId);
    }
}
