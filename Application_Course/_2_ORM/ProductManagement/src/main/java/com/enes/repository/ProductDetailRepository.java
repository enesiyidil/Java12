package com.enes.repository;

import com.enes.entity.ProductDetail;
import com.enes.utility.MyRepositoryFactory;

public class ProductDetailRepository extends MyRepositoryFactory<ProductDetail, Long> {
    public ProductDetailRepository() {
        super(ProductDetail.class);
    }
}
