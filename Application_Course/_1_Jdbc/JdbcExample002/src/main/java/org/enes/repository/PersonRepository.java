package org.enes.repository;

import org.enes.entity.Person;
import org.enes.util.JDBCHelper;

import java.sql.*;
import java.util.List;

public class PersonRepository implements ICrud {

    @Override
    public boolean register(Person person) {
        String query = "INSERT INTO persons(firstname, lastname, email) VALUES(?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCHelper.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, person.getFirstname());
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

    @Override
    public void getAllData() {
        Connection connection = null;
        try {
            connection = JDBCHelper.getConnection();
            List<Person> allData = findAll(Person.class, connection);
            allData.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException("Sorgu hatası: " + e);
        }finally {
            JDBCHelper.closeConnection(connection);
        }

    }

    @Override
    public void deleteAllData() {
        Connection connection = null;
        try {
            connection = JDBCHelper.getConnection();
            deleteAll(Person.class, connection);
        } catch (Exception e) {
            throw new RuntimeException("Sorgu hatası: " + e);
        }finally {
            JDBCHelper.closeConnection(connection);
        }
    }

    @Override
    public void findPersonById(int id) {
        Connection connection = null;
        try {
            connection = JDBCHelper.getConnection();
            System.out.println(findById(Person.class, connection, id));
        } catch (Exception e) {
            throw new RuntimeException("Sorgu hatası: " + e);
        }finally {
            JDBCHelper.closeConnection(connection);
        }
    }

    @Override
    public void deletePersonById(int id) {
        Connection connection = null;
        try {
            connection = JDBCHelper.getConnection();
            System.out.println(deleteById(Person.class, connection, id));
        } catch (Exception e) {
            throw new RuntimeException("Sorgu hatası: " + e);
        }finally {
            JDBCHelper.closeConnection(connection);
        }
    }

    public Person execute(String firstName, String email) {
        String query = "SELECT * FROM persons WHERE firstname= " + firstName + ", email= " + email;
        Statement statement = null;
        Person person = null;
        Connection connection = JDBCHelper.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String email1 = resultSet.getString("email");
            Date date = resultSet.getDate("joineddate");
            person = new Person(id, name, lastName, date, email1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

}
