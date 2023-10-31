package com.enes.entity;

import com.enes.util.RandomGenerateAccountNo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Account {

    private int id;
    private int userId;
    private double balance;
    private String accountNo;
    private Date transactionDate;

    public Account(int userId) {
        this.userId = userId;
        this.accountNo = RandomGenerateAccountNo.generateAccountNo();
    }

}
