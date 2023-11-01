package com.enes;

import com.enes.repository.UserRepository;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();

        // 2. savaAll
        /*User user = User.builder()
                .username("esma")
                .password("12345")
                .gender(EGender.MALE)
                .build();

        User user2 = User.builder()
                .username("selim")
                .password("12345")
                .gender(EGender.MALE)
                .build();
        List<User> users = Arrays.asList(user, user2);
        userRepository.saveAll(users);*/

        // 3. update
        /*User user = User.builder()
                .id(4L)
                .username("selim")
                .password("58965")
                .gender(EGender.MALE)
                .build();
        userRepository.update(user);*/

        // 4. findById
        /*Optional<User> user = userRepository.findById(3L);
        if (user.isPresent()) {
            System.out.println(user.get().getUsername());
        } else {
            System.out.println("Hatalı id");
        }*/
    }
}