package com.enes.controller;

import com.enes.entity.Category;
import com.enes.entity.Customer;
import com.enes.entity.Product;
import com.enes.service.ProductService;
import com.enes.utility.BAUtils;

import java.util.List;
import java.util.Optional;

public class ProductController {

    private final ProductService productService;
    private final CategoryController categoryController;

    public ProductController() {
        this.productService = new ProductService();
        this.categoryController = new CategoryController();
    }

    public void save() {
        String name = BAUtils.readString("Product Name: ");
        Double price = BAUtils.readDouble("Product Price: ");
        Integer stock = BAUtils.readInt("Product Stock: ");
        int categoryId = BAUtils.readInt("Product Category Id: ");
        Optional<Category> optionalCategory = categoryController.findById(categoryId);
        Product product = Product.builder()
                .name(name)
                .price(price)
                .stock(stock)
                .category(optionalCategory.get())
                .build();
        productService.save(product);
    }

    public void buyProduct(Customer customer) {
        long id = BAUtils.readInt("Almak istediğiniz ürün id: ");
        int amount = BAUtils.readInt("Kaç adet: ");

        Optional<Product> optionalProduct = productService.buyProduct(id, amount);
        optionalProduct.get().getCustomers().add(customer);
        optionalProduct.get().setStock(optionalProduct.get().getStock() - amount);
        productService.update(optionalProduct.get());
    }

    public List<Product> findAll() {
        return productService.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productService.findById(id);
    }

    public List<Product> findProductByLessThan10InStock() {
        return productService.findProductByLessThan10InStock();
    }
}
