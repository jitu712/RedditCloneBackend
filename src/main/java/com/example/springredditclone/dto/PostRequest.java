package com.example.springredditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PostRequest {
    private Long postId;

    public PostRequest() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubredditName() {
        return subredditName;
    }

    public void setSubredditName(String subredditName) {
        this.subredditName = subredditName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public PostRequest(Long postId, String postName, String subredditName, String url, String description) {
        this.setPostId(postId);
        this.setPostName(postName);
        this.setSubredditName(subredditName);
        this.setUrl(url);
        this.setDescription(description);
    }

    private String postName;
    private String subredditName;
    private String url;
    private String description;
}
