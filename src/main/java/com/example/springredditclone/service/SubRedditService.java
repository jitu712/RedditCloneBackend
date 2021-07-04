package com.example.springredditclone.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import com.example.springredditclone.dto.SubRedditDto;
import com.example.springredditclone.exceptions.SpringRedditException;
import com.example.springredditclone.mapper.SubRedditMapper;
import com.example.springredditclone.model.Subreddit;
import com.example.springredditclone.repository.SubredditRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class SubRedditService {

    private SubredditRepository subredditRepository;
    private final SubRedditMapper subRedditMapper;

    public SubRedditDto save(SubRedditDto subRedditDto) {
        Subreddit subReddit = subRedditMapper.mapDtoToSubReddit(subRedditDto);
        Subreddit save = subredditRepository.save(subReddit);
        subRedditDto.setId(save.getId());
        return subRedditDto;
    }

    // private SubReddit mapSubRedditDto(SubRedditDto subRedditDto) {
    // return
    // SubReddit.builder().name(subRedditDto.getName()).description(subRedditDto.getDescription()).build();
    // }

    public List<SubRedditDto> getAll() {
        return subredditRepository.findAll().stream().map(subRedditMapper::mapSubRedditToDto).collect(toList());
    }

    // private SubRedditDto maptoDto(SubReddit subReddit) {
    // return
    // SubRedditDto.builder().name(subReddit.getName()).description(subReddit.getDescription())
    // .id(subReddit.getId()).numberOfPosts(subReddit.getPosts().size()).build();
    // }

    public SubRedditDto getSubreddit(Long id) {
        Subreddit subReddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("No subreddit found with id " + id));
        return subRedditMapper.mapSubRedditToDto(subReddit);
    }

}
