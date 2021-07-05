package com.home.service;

import com.home.dto.PageDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PageService {
    PageDto saveAndParse(PageDto pageDto);

    List<PageDto> findAll();
}
