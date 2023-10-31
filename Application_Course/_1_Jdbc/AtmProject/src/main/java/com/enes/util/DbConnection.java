package com.enes.util;

import com.enes.util.constant.JDBCConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static DbConnection instance;
    private Connection connection;

    private DbConnection() {
        createConnection();
    }

    private void createConnection() {
        try {
            connection = DriverManager.getConnection(JDBCConstant.CONNECTION_ADDRESS, JDBCConstant.USERNAME, JDBCConstant.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DbConnection getInstance(){
        if(instance == null){
            instance = new DbConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
