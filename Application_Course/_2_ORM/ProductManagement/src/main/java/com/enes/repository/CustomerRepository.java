package com.enes.repository;

import com.enes.entity.Customer;
import com.enes.utility.MyRepositoryFactory;

public class CustomerRepository extends MyRepositoryFactory<Customer, Long> {
    public CustomerRepository() {
        super(Customer.class);
    }
}
