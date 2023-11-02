package com.enes;

import com.enes.service.PostService;
import com.enes.service.UserService;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        //userService.save();

        userService.deneme().forEach(System.out::println);
        PostService postService = new PostService();
        //postService.createPost();

//        System.out.println("findAll");
//        userService.findAll().forEach(user -> {
//            System.out.println(user);
//        });
//        System.out.println("findAllInformation");
//        userService.findAllInformation().forEach(System.out::println);
//        System.out.println("findAllInformationName");
//        userService.findAllInformationName().forEach(System.out::println);
//
//        List<String> interests3 = Arrays.asList("Software", "Dergi");
//
//        Map<EAddressType, Address> adres3 = new HashMap<>();
//        adres3.put(EAddressType.HOME, Address.builder()
//                .country("İspanya")
//                .city("Madrid")
//                .street("YStreet")
//                .build());
//        Information information3 = Information.builder()
//                .surname("yaz")
//                .middlename("mahmut")
//                .name("serkan")
//                .build();
//        User user3 = User.builder()
//                .password("123456")
//                .username("serko")
//                .information(information3)
//                .interests(interests3)
//                .addresses(adres3)
//                .build();
//        System.out.println(user3);

    }
}