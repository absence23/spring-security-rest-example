package com.example.demo.persistence;

import com.example.demo.domain.entity.PostImage;
import org.springframework.data.repository.CrudRepository;

public interface PostImageRepository extends CrudRepository<PostImage, Long> {
    PostImage findByPostId(Long postId);
}
