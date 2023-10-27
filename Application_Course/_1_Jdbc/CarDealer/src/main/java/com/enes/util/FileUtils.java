package com.enes.util;

import com.enes.entity.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public List<String> readFile(String path){
        File file = new File("Application_Course\\_1_Jdbc\\CarDealer\\src\\" + path);
        List<String> datas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                datas.add(satir);
            }
        } catch (Exception e) {
            System.out.println("Dosya okuma hatası " + e);
        }
        return  datas;
    }

    public List<Car> createCarList(List<String> data){
        List<Car> carList = new ArrayList<>();
        for (String item : data) {
            carList.add(convertToCar(item.split(",")));
        }
        return carList;
    }

    public Car convertToCar(String[] array){
        Car car = new Car(Integer.parseInt(array[0]), array[1], array[2], array[3], Integer.parseInt(array[4]));
        return car;
    }
}
