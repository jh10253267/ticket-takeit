package com.tickettakeit.domain.category.service.impl;

import com.tickettakeit.domain.category.dao.CategoryDAO;
import com.tickettakeit.domain.category.dto.CategoryResponse;
import com.tickettakeit.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryResponse getCategories() {
        CategoryResponse categoryResponse =  new CategoryResponse();
        categoryResponse.setItems(categoryDAO.selectAllCategories());
        return categoryResponse;

    }

}
