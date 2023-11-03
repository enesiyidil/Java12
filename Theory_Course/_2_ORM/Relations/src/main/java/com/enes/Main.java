package com.enes;

import com.enes.repository.AddressRepository;
import com.enes.repository.DepartmentRepository;
import com.enes.repository.PersonelRepository;
import com.enes.repository.entity.Address;
import com.enes.repository.entity.Car;
import com.enes.repository.entity.Department;
import com.enes.repository.entity.Personel;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PersonelRepository personelRepository = new PersonelRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();
        AddressRepository addressRepository = new AddressRepository();

        // Department oluşturup kaydedelim
        Department departmentSatis = Department.builder()
                .name("Satış Departmanı")
                .build();
        Department departmentMuhasebe = Department.builder()
                .name("Muhasebe Departmanı")
                .build();
//        departmentRepository.save(departmentSatis);
//        departmentRepository.save(departmentMuhasebe);

        // Car oluşturalım
        Car carAudi = Car.builder()
                .make("Audi")
                .model("A8")
                .plate("34AUD001")
                .build();
        Car carBMW = Car.builder()
                .make("BMW")
                .model("I8")
                .plate("34BMW001")
                .build();

        // Adresleri oluşturalım
        Address address1 = Address.builder()
                .city("İstanbul")
                .street("Vatan Cd.")
                .number("10")
                .build();
        Address address2 = Address.builder()
                .city("Ankara")
                .street("Sal Cd.")
                .number("3")
                .build();
        Address address3 = Address.builder()
                .city("Antalya")
                .street("Deniz Cd.")
                .number("101")
                .build();
        addressRepository.saveAll(List.of(address1, address2, address3));

        // Personelleri oluşturup, departmanlarınıdaverip, kaydedelim
        Personel p1 = Personel.builder()
                .name("Hakan")
                .age(35)
                .car(carAudi)
                .department(departmentSatis)
                .addresses(List.of(address1,address2))
                .build();
        Personel p2 = Personel.builder()
                .name("Can")
                .age(30)
                .car(carBMW)
                .department(departmentSatis)
                .build();
        Personel p3 = Personel.builder()
                .name("Bilge")
                .age(40)
                .department(departmentMuhasebe)
                .addresses(List.of(address3,address2))
                .build();

        departmentSatis.setPersonelList(List.of(p1, p2));
        departmentMuhasebe.setPersonelList(List.of(p3));

        personelRepository.saveAll(List.of(p1, p2, p3));

        // Önce personel tarafından sorgu atalım
//        personelRepository.findById(2L).ifPresent(personel -> {
//            System.out.println(personel.getDepartment().getName());
//        });

//        personelRepository.findAll().forEach(System.out::println);
//        addressRepository.findAll().forEach(System.out::println);
//        departmentRepository.findAll().forEach(System.out::println);

//        personelRepository.deleteById(2L);
//        departmentRepository.deleteById(1L);
        addressRepository.deleteById(3L);

    }
}