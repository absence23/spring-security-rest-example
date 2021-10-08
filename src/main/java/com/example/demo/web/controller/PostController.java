package com.example.demo.web.controller;

import com.example.demo.domain.dto.PostDto;
import com.example.demo.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        LOGGER.debug("Getting all the posts");
        return postService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> addPost(@RequestBody PostDto post) {
        LOGGER.debug("Adding new post [{}]", post);
        return ResponseEntity.ok(postService.save(post));
    }
}
