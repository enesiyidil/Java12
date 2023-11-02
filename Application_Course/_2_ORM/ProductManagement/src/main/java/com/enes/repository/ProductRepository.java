package com.enes.repository;

import com.enes.entity.Product;
import com.enes.utility.MyRepositoryFactory;

public class ProductRepository extends MyRepositoryFactory<Product, Long> {
    public ProductRepository() {
        super(Product.class);
    }
}
