package com.enes.service;

import com.enes.entity.Customer;
import com.enes.repository.CustomerRepository;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    public void register(Customer customer){
        customerRepository.save(customer);
    }
}
