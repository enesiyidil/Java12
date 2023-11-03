package com.enes.service;

import com.enes.entity.Category;
import com.enes.repository.CategoryRepository;

import java.util.Optional;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService() {
        categoryRepository = new CategoryRepository();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
}
