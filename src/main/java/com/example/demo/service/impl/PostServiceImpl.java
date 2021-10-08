package com.example.demo.service.impl;

import com.example.demo.domain.dto.PostDto;
import com.example.demo.domain.entity.Post;
import com.example.demo.persistence.PostRepository;
import com.example.demo.service.PostService;
import com.example.demo.service.converter.Converter;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final Converter<Post, PostDto> converter;

    public PostServiceImpl(PostRepository postRepository, Converter<Post, PostDto> converter) {
        this.postRepository = postRepository;
        this.converter = converter;
    }

    @Override
    public PostDto findById(Long id) {
        return postRepository.findById(id).map(converter::toDto).orElse(null);
    }

    @Override
    public List<PostDto> findAll() {
        return converter.toDto(Lists.newArrayList(postRepository.findAll()));
    }

    @Override
    public PostDto save(PostDto post) {
        return converter.toDto(postRepository.save(converter.toEntity(post)));
    }
}
