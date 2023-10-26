package org.enes.util;

import org.enes.controller.PersonController;
import org.enes.entity.Person;

import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    private PersonController personController;

    public Menu() {
        this.personController = new PersonController();
    }

    public void menu() {
        while (true) {
            System.out.println("----------Database İşlemleri----------");
            System.out.println("1 --> Database veri ekleme");
            System.out.println("2 --> Database tum verileri goruntuleme.");
            System.out.println("3 --> Database tum verileri silme.");
            System.out.println("4 --> Database mail guncelleme.");
            System.out.println("5 --> Databasede id ile veri arama");
            System.out.println("6 --> Databasede id ile veri silme.");

            System.out.print("Seçiminiz: ");
            int election = scanner.nextInt();
            scanner.nextLine();
            int id;
            switch (election) {
                case 1:
                    System.out.print("İsim: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Soyisim: ");
                    String lastName = scanner.nextLine();
                    System.out.print("eMail: ");
                    String email = scanner.nextLine();
                    Person person = new Person(firstName, lastName, email);
                    if(personController.register(person)){
                        System.out.println("Kayıt başarılı.");
                    }else {
                        System.out.println("Kayıt başarısız.");
                    }
                    break;
                case 2:
                    System.out.println("person db tüm datalar:");
                    personController.getAllData();
                    break;
                case 3:
                    personController.deleteAllData();
                    break;
                case 4:

                    break;
                case 5:
                    System.out.print("Id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    personController.findPersonById(id);
                    break;
                case 6:
                    System.out.print("Id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    personController.deletePersonById(id);
                    break;
            }
        }
    }
}
