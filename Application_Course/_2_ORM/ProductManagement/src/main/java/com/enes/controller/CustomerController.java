package com.enes.controller;

import com.enes.entity.Customer;
import com.enes.entity.Information;
import com.enes.service.CustomerService;
import com.enes.utility.BAUtils;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerService();
    }

    public void register(){
        String firstName = BAUtils.readString("İsminiz: ");
        String lastName = BAUtils.readString("Soyisminiz: ");
        String email = BAUtils.readString("Email: ");
        Information information = Information.builder()
                .firstname(firstName)
                .lastname(lastName)
                .email(email)
                .build();

        String password = BAUtils.readString("Şifreniz: ");
        String identity = BAUtils.readString("TC'niz: ");
        Customer customer = Customer.builder()
                .identity(identity)
                .password(password)
                .information(information)
                .build();
        customerService.register(customer);
    }
}
