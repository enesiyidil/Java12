package com.enes.repository;

import com.enes.entity.Category;
import com.enes.utility.MyRepositoryFactory;

public class CategoryRepository extends MyRepositoryFactory<Category, Long> {
    public CategoryRepository() {
        super(Category.class);
    }
}
