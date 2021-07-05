package com.home.entity;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer pageId;

    @Column
    private String name;

    @Column
    private Integer count;

    public static class Builder {
        private Statistics statistics;

        public Builder() {
            statistics = new Statistics();
        }

        public Builder setId(Integer id) {
            statistics.id = id;
            return this;
        }

        public Builder setPageId(Integer pageId) {
            statistics.pageId = pageId;
            return this;
        }

        public Builder setName(String name) {
            statistics.name = name;
            return this;
        }

        public Builder setCount(Integer count) {
            statistics.count = count;
            return this;
        }

        public Statistics build() {
            return statistics;
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