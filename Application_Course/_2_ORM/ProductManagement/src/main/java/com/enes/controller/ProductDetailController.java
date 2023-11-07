package com.enes.controller;

import com.enes.entity.Product;
import com.enes.entity.ProductDetail;
import com.enes.service.ProductDetailService;
import com.enes.utility.BAUtils;

import java.util.List;
import java.util.Optional;

public class ProductDetailController {

    private final ProductDetailService productDetailService;

    private final ProductController productController;

    public ProductDetailController(){
        this.productDetailService = new ProductDetailService();
        this.productController = new ProductController();
    }

    public void addComment() {
        Long id = (long) BAUtils.readInt("Yorum yapılacak ürün id");
        Optional<Product> optionalProduct = productController.findById(id);
        String comment = BAUtils.readString("Yorumunuz");
        Double score = BAUtils.readDouble("Puanınız");
        ProductDetail productDetail = ProductDetail.builder()
                .product(optionalProduct.get())
                .comment(comment)
                .score(score)
                .build();
        productDetailService.addComment(productDetail);
    }

    public List<ProductDetail> findAllByProductId() {
        Long productId = (long) BAUtils.readInt("ürün id");
        Optional<Product> optionalProduct = productController.findById(productId);
        return productDetailService.findAllByProductId(optionalProduct);
    }
}
