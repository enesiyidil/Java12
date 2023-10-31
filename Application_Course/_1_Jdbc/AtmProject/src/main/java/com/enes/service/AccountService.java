package com.enes.service;

import com.enes.entity.Account;
import com.enes.entity.User;
import com.enes.repository.AccountRepository;

import java.util.List;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    public void createAccount(User user) {
        String accountNo = accountRepository.createAccount(user);
        System.out.println("Hesabınız oluşturuldu. Hesap No: " + accountNo);
    }

    public List<Account> getAccountByEmail(String email){
        return accountRepository.getAccountByEmail(email);
    }

    public boolean transferMoney(double amount, String accountNo){
        return accountRepository.transferMoney(amount, accountNo);
    }
}
