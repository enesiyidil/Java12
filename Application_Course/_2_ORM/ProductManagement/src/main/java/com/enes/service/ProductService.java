package com.enes.service;

import com.enes.entity.Product;
import com.enes.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> buyProduct(long id, int amount) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            if (optionalProduct.get().getStock() >= amount) {
                return optionalProduct;
            } else {
                System.out.println("Stock yetersiz!");
            }
        } else {
            System.out.println("Product bulunamadı!");
        }
        return Optional.empty();
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findProductByLessThan10InStock() {
        return productRepository.findByCondition((criteriaBuilder, productRoot) -> criteriaBuilder.lessThanOrEqualTo(productRoot.get("stock"), 10));
    }
}
