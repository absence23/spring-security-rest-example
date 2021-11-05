package com.example.demo.web.controller;

import com.example.demo.domain.dto.CategoryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @GetMapping
    public List<CategoryDto> getCategories() {
        List<CategoryDto> categories = new ArrayList<>();
        categories.add(new CategoryDto(1L, "Sport"));
        categories.add(new CategoryDto(2L, "IT"));
        categories.add(new CategoryDto(3L, "Finance"));
        return categories;
    }
}
