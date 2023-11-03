package com.enes.controller;

import com.enes.entity.Category;
import com.enes.service.CategoryService;
import com.enes.utility.BAUtils;

import java.util.Optional;

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController() {
        this.categoryService = new CategoryService();
    }

    public void save(){
        String categoryName = BAUtils.readString("Category Name: ");
        Category category = Category.builder()
                .name(categoryName)
                .build();
        categoryService.save(category);
    }

    public Optional<Category> findById(long categoryId) {
        return categoryService.findById(categoryId);
    }
}
