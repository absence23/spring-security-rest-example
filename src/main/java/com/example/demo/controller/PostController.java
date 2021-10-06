package com.example.demo.controller;

import com.example.demo.domain.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);
    private List<Post> posts = new ArrayList<>();

    {
        posts.add(new Post("1 Post", "Lorem ipsum"));
        posts.add(new Post("2 Post", "Lorem ipsum"));
        posts.add(new Post("3 Post", "Lorem ipsum"));
        posts.add(new Post("4 Post", "Lorem ipsum"));
        posts.add(new Post("5 Post", "Lorem ipsum"));
    }

    @GetMapping
    public List<Post> getAllPosts() {
        LOGGER.debug("Getting all the posts");
        return posts;
    }

    @PostMapping
    public ResponseEntity<Object> addPost(@RequestBody Post post) {
        LOGGER.debug("Adding new post [{}]", post);
        posts.add(post);
        return ResponseEntity.ok(post);
    }
}
