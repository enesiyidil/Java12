package org.enes.repository;

import org.enes.entity.Person;
import org.enes.util.JDBCHelper;

import java.sql.*;

public class PersonRepository implements ICrud {



    @Override
    public boolean save(Person person) {
        String query = "INSERT INTO person(first_name, last_name, email) VALUES(?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCHelper.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, person.getFirtsName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Sorgu hatası: " + e);
        }finally {
            JDBCHelper.closeConnection(connection);
            JDBCHelper.closePreparedStatement(preparedStatement);
        }
    }

    public Person execute(String firstName, String email) {
        String query = "SELECT * FROM person WHERE first_name= " + firstName + ", email= " + email;
        Statement statement = null;
        Person person = null;
        Connection connection = JDBCHelper.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email1 = resultSet.getString("email");
            Date date = resultSet.getDate("joined_date");
            person = new Person(id, name, lastName, date, email1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}
