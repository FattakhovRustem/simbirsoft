package com.home.service.converter;

import com.home.dto.PageDto;
import com.home.entity.Page;
import org.springframework.stereotype.Component;

@Component
public class PageConverter {

    public Page fromPageDtoToPage(PageDto pageDto) {
        return new Page.Builder()
                .setId(pageDto.getId())
                .setName(pageDto.getName())
                .setLink(pageDto.getLink())
                .build();
    }

    public PageDto fromPageToPageDto(Page page) {
        return new PageDto.Builder()
                .setId(page.getId())
                .setName(page.getName())
                .setLink(page.getLink())
                .build();
    }
}