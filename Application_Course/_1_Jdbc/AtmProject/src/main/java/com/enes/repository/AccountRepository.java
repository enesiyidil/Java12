package com.enes.repository;

import com.enes.entity.Account;
import com.enes.entity.User;
import com.enes.util.DbConnection;
import com.enes.util.RandomGenerateAccountNo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountRepository {

    public String createAccount(User user) {
        String query = "INSERT INTO accounts(user_id, account_no) VALUES(?,?)";
        PreparedStatement preparedStatement = null;
        Account account = Account.builder()
                .userId(user.getId())
                .accountNo(RandomGenerateAccountNo.generateAccountNo())
                .build();
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setInt(1, account.getUserId());
            preparedStatement.setString(2, account.getAccountNo());
            if (preparedStatement.executeUpdate() > 0) {
                return account.getAccountNo();
            } else {
                throw new RuntimeException("Hesap oluşturulamadı.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Account> getAccountByEmail(String email) {
        String query = "Select a.* FROM accounts AS a JOIN users AS u ON u.id = a.user_id WHERE u.email = ?";
        PreparedStatement preparedStatement = null;
        List<Account> accounts = new ArrayList<>();
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int existedId = resultSet.getInt("id");
                int existedUserId = resultSet.getInt("user_id");
                double existedBalance = resultSet.getDouble("balance");
                String existedAccountNo = resultSet.getString("account_no");
                Date existedDate = resultSet.getDate("creation_date");
                Account account = new Account(existedId, existedUserId, existedBalance, existedAccountNo, existedDate);
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean transferMoney(double amount, String accountNo) {
        String query = "UPDATE accounts SET balance = ? WHERE account_no = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, accountNo);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            } else {
                throw new RuntimeException("Hesap oluşturulamadı.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
