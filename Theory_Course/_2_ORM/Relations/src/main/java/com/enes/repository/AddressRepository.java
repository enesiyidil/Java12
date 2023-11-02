package com.enes.repository;

import com.enes.repository.entity.Address;
import com.enes.utility.MyRepositoryFactory;

public class AddressRepository extends MyRepositoryFactory<Address, Long> {
    public AddressRepository() {
        super(Address.class);
    }
}
