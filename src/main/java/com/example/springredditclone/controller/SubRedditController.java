package com.example.springredditclone.controller;

import java.util.List;

import com.example.springredditclone.dto.SubRedditDto;
import com.example.springredditclone.service.SubRedditService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/subreddit")
@AllArgsConstructor
@Slf4j
public class SubRedditController {

    private SubRedditService subRedditService;

    @PostMapping
    public ResponseEntity<SubRedditDto> createSubReddit(@RequestBody SubRedditDto subRedditDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subRedditService.save(subRedditDto));
    }

    @GetMapping
    public ResponseEntity<List<SubRedditDto>> getAllSubreddit() {
        return ResponseEntity.status(HttpStatus.OK).body(subRedditService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubRedditDto> getSubreddit(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(subRedditService.getSubreddit(id));
    }

}
