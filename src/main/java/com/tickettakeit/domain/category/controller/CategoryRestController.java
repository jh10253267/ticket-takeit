package com.tickettakeit.domain.category.controller;

import com.tickettakeit.domain.category.dto.CategoryResponse;
import com.tickettakeit.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryRestController {
    private final CategoryService categoryService;
    @GetMapping
    public CategoryResponse getCategories() {
        return categoryService.getCategories();
    }
}