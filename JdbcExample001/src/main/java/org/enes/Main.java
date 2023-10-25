package org.enes;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String dbName = "school_Java12";
        String connectionAddress = "jdbc:postgresql://localhost:5432/" + dbName;
        String username = "postgres";
        String password = "1234";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionAddress, username, password);
            System.out.println("Bağlantı başarılı");

            /*
            String query = "INSERT INTO student(name, surname, city) VALUES('Mehmet', 'Yardımcı', 'Ankara')";
            execute(connection, query);
             */
            /*
            Student student = new Student("Ahmet", "Kara", "Ordu");
            createStudent(connection, student);
            */

            /*
            Student student1 = findById(connection,2);
            student1.setName("Salih");
            updateStudent(connection, student1);
            */

            findStudentsByCityName(connection, "Ordu");

        } catch (SQLException e) {
            System.out.println("Bağlantı hatası" + e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Bağlantı kapatma işlemi başarılı");
                }
            } catch (SQLException e) {
                System.out.println("Bağlantı kapatma hatası" + e);
            }
        }
    }

    public static void execute(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(query);
        System.out.println("İşlem başarılı");
    }

    public static void createStudent(Connection connection, Student student) throws SQLException {
        String sql = "INSERT INTO student(name, surname, city) VALUES(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getSurname());
        preparedStatement.setString(3, student.getCity());
        preparedStatement.executeUpdate();
    }

    public static void updateStudent(Connection connection, Student student) throws SQLException {
        String sql = "UPDATE student SET name=?, surname=?, city=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getSurname());
        preparedStatement.setString(3, student.getCity());
        preparedStatement.setInt(4, student.getId());
        preparedStatement.executeUpdate();
    }

    public static Student findById(Connection connection, int id) throws SQLException {
        String sql = "SELECT * FROM student WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id1 = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String city = resultSet.getString("city");
        return new Student(id1, name, surname, city);
    }

    public static void findStudentsByCityName(Connection connection, String cityName) throws SQLException {
        String sql = "SELECT * FROM student WHERE city=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cityName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id1 = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String city = resultSet.getString("city");
            Student student = new Student(id1, name, surname, city);
            System.out.println(student);
        }
    }
}