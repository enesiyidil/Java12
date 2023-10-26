package org.enes.util;

import org.enes.util.constant.JDBCConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCHelper {

    public static Connection getConnection(){
        try {
            return  DriverManager.getConnection(JDBCConstant.CONNECTION_ADDRESS, JDBCConstant.USERNAME, JDBCConstant.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static  void closeConnection(Connection connection){
        if(connection != null){
            try {
                connection.close();
                System.out.println("Bağlantı kapatıldı.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static  void closePreparedStatement(PreparedStatement preparedStatement){
        if(preparedStatement != null){
            try {
                preparedStatement.close();
                System.out.println("preparedStatement kapatıldı.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
