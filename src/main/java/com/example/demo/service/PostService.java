package com.example.demo.service;

import com.example.demo.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto findById(Long id);

    List<PostDto> findAll();

    PostDto save(PostDto object);
}
