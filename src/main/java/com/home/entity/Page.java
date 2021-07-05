package com.home.entity;

import javax.persistence.*;

@Entity
@Table(name = "page")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String link;

    public static class Builder {
        private Page newPage;

        public Builder() {
            this.newPage = new Page();
        }

        public Builder setId(Integer id) {
            newPage.id = id;
            return this;
        }

        public Builder setName(String name) {
            newPage.name = name;
            return this;
        }

        public Builder setLink(String link) {
            newPage.link = link;
            return this;
        }

        public Page build() {
            return newPage;
        }
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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