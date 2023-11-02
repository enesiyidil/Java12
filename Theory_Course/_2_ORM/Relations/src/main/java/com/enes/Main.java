package com.enes;

import com.enes.repository.DepartmentRepository;
import com.enes.repository.PersonelRepository;
import com.enes.repository.entity.Department;
import com.enes.repository.entity.Personel;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Department oluşturup kaydedelim
        DepartmentRepository departmentRepository = new DepartmentRepository();
        Department departmentSatis = Department.builder()
                .name("Satış Departmanı")
                .build();
        Department departmentMuhasebe = Department.builder()
                .name("Muhasebe Departmanı")
                .build();
        departmentRepository.save(departmentSatis);
        departmentRepository.save(departmentMuhasebe);

        // Personelleri oluşturup, departmanlarınıdaverip, kaydedelim
        PersonelRepository personelRepository = new PersonelRepository();
        Personel p1 = Personel.builder()
                .name("Hakan")
                .age(35)
                .department(departmentSatis)
                .build();
        Personel p2 = Personel.builder()
                .name("Can")
                .age(30)
                .department(departmentSatis)
                .build();
        Personel p3 = Personel.builder()
                .name("Bilge")
                .age(40)
                .department(departmentMuhasebe)
                .build();
        personelRepository.saveAll(List.of(p1, p2, p3));

        // Önce personel tarafından sorgu atalım
//        personelRepository.findById(2L).ifPresent(personel -> {
//            System.out.println(personel.getDepartment().getName());
//        });

        personelRepository.findAll().forEach(System.out::println);
        departmentRepository.findAll().forEach(System.out::println);

        personelRepository.deleteById(2L);

    }
}