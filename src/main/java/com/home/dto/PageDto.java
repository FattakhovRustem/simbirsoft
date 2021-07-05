package com.home.dto;

public class PageDto {
    private Integer id;
    private String name;
    private String link;

    public static class Builder {
        private PageDto newPageDto;

        public Builder() {
            this.newPageDto = new PageDto();
        }

        public Builder setId(Integer id) {
            newPageDto.id = id;
            return this;
        }

        public Builder setName(String name) {
            newPageDto.name = name;
            return this;
        }

        public Builder setLink(String link) {
            newPageDto.link = link;
            return this;
        }

        public PageDto build() {
            return newPageDto;
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
