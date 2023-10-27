package com.enes;

import com.enes.repository.CarRepository;
import com.enes.util.FileUtils;

public class Main {
    public static void main(String[] args) {

        FileUtils fileUtils = new FileUtils();
        CarRepository carRepository = new CarRepository();
        carRepository.saveAll(fileUtils.createCarList(fileUtils.readFile("car.csv")));

    }

}