package com.enes.repository;

import com.enes.repository.entity.User;
import com.enes.utility.MyRepositoryFactory;

public class UserRepository extends MyRepositoryFactory<User, Long> {
    public UserRepository() {
        super(User.class);
    }
}
