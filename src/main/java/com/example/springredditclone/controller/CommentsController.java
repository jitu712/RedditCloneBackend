package com.example.springredditclone.controller;

import com.example.springredditclone.dto.CommentsDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comments/")
public class CommentsController {

    @PostMapping
    public void createComment(@RequestBody CommentsDto commentsDto) {

    }

}
