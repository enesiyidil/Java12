package com.enes.service;

import com.enes.entity.Customer;
import com.enes.repository.CustomerRepository;

import java.util.Optional;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    public void register(Customer customer){
        customerRepository.save(customer);
    }

    public Optional<Customer> findCustomerByIdentity(String identity, String password) {
        Optional<Customer> optinalCustomer = customerRepository.findCustomerByIdentity(identity);
        if(optinalCustomer.isPresent()){
            if(optinalCustomer.get().getPassword().equals(password)){
                return optinalCustomer;
            }else {
                System.out.println("Password is Not Valid!");
            }
        }else {
            System.out.println("Customer Not Found");
        }
        return Optional.empty();
    }
}
