package com.example.springredditclone.mapper;

import java.util.List;

import com.example.springredditclone.dto.SubRedditDto;
import com.example.springredditclone.model.Post;
import com.example.springredditclone.model.Subreddit;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubRedditMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subReddit.getPosts()))")
    SubRedditDto mapSubRedditToDto(Subreddit subReddit);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subreddit mapDtoToSubReddit(SubRedditDto subRedditDto);
}
