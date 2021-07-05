package com.home.dto;

public class StatisticsDto {

    private Integer id;
    private Integer pageId;
    private String name;
    private Integer count;

    public static class Builder {
        private StatisticsDto newStatisticsDto;

        public Builder() {
            newStatisticsDto = new StatisticsDto();
        }

        public Builder setId(Integer id) {
            newStatisticsDto.id = id;
            return this;
        }

        public Builder setPageId(Integer pageId) {
            newStatisticsDto.pageId = pageId;
            return this;
        }

        public Builder setName(String name) {
            newStatisticsDto.name = name;
            return this;
        }

        public Builder setCount(Integer count) {
            newStatisticsDto.count = count;
            return this;
        }

        public StatisticsDto build() {
            return newStatisticsDto;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}