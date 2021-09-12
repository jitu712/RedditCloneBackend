package com.example.springredditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Builder
public class SubRedditDto {
    private Long id;

    public SubRedditDto(Long id, String name, String description, Integer numberOfPosts) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.numberOfPosts = numberOfPosts;
    }

    public SubRedditDto() {
    }

    private String name;
    private String description;
    private Integer numberOfPosts;

    public Long getId() {
        return id;
    }

    public Integer getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(Integer numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
