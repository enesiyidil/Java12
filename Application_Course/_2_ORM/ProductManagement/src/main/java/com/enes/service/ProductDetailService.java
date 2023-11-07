package com.enes.service;

import com.enes.entity.Product;
import com.enes.entity.ProductDetail;
import com.enes.repository.ProductDetailRepository;

import java.util.List;
import java.util.Optional;

public class ProductDetailService {

    private final ProductDetailRepository productDetailRepository;

    public ProductDetailService(){
        this.productDetailRepository = new ProductDetailRepository();
    }

    public void addComment(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    public List<ProductDetail> findAllByProductId(Optional<Product> product) {
        return productDetailRepository.findByCondition((criteriaBuilder, productDetailRoot) -> criteriaBuilder.equal(productDetailRoot.get("product"), product.get()));
    }
}
