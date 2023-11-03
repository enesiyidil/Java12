package com.enes.app;

import com.enes.controller.CategoryController;
import com.enes.controller.CustomerController;
import com.enes.controller.ProductController;
import com.enes.entity.Customer;
import com.enes.utility.BAUtils;

import java.util.HashMap;

public class Menu {

    private final CustomerController customerController;
    private final CategoryController categoryController;
    private final ProductController productController;

    public Menu() {
        this.customerController = new CustomerController();
        this.categoryController = new CategoryController();
        this.productController = new ProductController();
    }

    public void menu(){
        HashMap<Integer, String> menuItems = new HashMap<>();
        menuItems.put(1, "Admin");
        menuItems.put(2, "Customer");

        int key = BAUtils.menu(menuItems);

        switch (key){
            case 1:
                adminMenu();
                break;
            case 2:
                customerMenu();
                break;
        }
    }

    private void adminMenu() {
        HashMap<Integer, String> menuItems = new HashMap<>();
        menuItems.put(1, "Product Ekle");
        menuItems.put(2, "Category Ekle");

        int key = BAUtils.menu(menuItems);

        switch (key){
            case 1:
                productController.save();
                break;
            case 2:
                categoryController.save();
                break;
        }
    }

    private void customerMenu() {
        HashMap<Integer, String> menuItems = new HashMap<>();
        menuItems.put(1, "Kayıt Ol");
        menuItems.put(2, "Giriş Yap");

        int key = BAUtils.menu(menuItems);

        switch (key){
            case 1:
                customerController.register();
                break;
            case 2:
                customerManagerMenu(customerController.login().get());
                break;
        }
    }
    private void customerManagerMenu(Customer customer) {
        HashMap<Integer, String> menuItems = new HashMap<>();
        menuItems.put(1, "Satın Al");

        int key = BAUtils.menu(menuItems);

        switch (key){
            case 1:
                productController.buyProduct(customer);
                break;
            case 2:

                break;
        }
    }
}
