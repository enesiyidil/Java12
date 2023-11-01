package com.enes.repository;

import com.enes.repository.entity.Post;
import com.enes.utility.MyRepositoryFactory;

public class PostRepository extends MyRepositoryFactory<Post, Long> {
    public PostRepository() {
        super(Post.class);
    }
}
