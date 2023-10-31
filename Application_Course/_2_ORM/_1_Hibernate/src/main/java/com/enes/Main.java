package com.enes;

import com.enes.service.PostService;
import com.enes.service.UserService;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        userService.save();

        PostService postService = new PostService();
        postService.createPost();

    }
}