package com.enes.repository;

import com.enes.repository.entity.Car;
import com.enes.utility.MyRepositoryFactory;

public class CarRepository extends MyRepositoryFactory<Car, Long> {
    public CarRepository() {
        super(Car.class);
    }
}
