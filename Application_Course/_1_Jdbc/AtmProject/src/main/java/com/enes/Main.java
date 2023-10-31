package com.enes;

import com.enes.entity.Account;
import com.enes.entity.User;
import com.enes.repository.UserRepository;
import com.enes.service.AccountService;
import com.enes.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        AccountService accountService = new AccountService();

//        User user = userService.login("mehmet@gmail.com", "12345");
//        accountService.createAccount(user);

        List<Account> accountByEmail = accountService.getAccountByEmail("mehmet@gmail.com");
        System.out.println(accountByEmail);
        accountService.transferMoney(100, accountByEmail.get(0).getAccountNo());

    }
}