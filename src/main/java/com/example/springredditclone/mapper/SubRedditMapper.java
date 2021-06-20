package com.example.springredditclone.mapper;

import java.util.List;

import com.example.springredditclone.dto.SubRedditDto;
import com.example.springredditclone.model.Post;
import com.example.springredditclone.model.SubReddit;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubRedditMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subReddit.getPosts()))")
    SubRedditDto mapSubRedditToDto(SubReddit subReddit);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    SubReddit mapDtoToSubReddit(SubRedditDto subRedditDto);
}
