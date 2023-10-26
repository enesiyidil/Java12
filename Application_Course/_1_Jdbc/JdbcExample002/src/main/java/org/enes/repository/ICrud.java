package org.enes.repository;

import org.enes.entity.Person;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ICrud {

    boolean register(Person person);

    void getAllData();

    void deleteAllData();

    void findPersonById(int id);

    void deletePersonById(int id);

    default <T> void deleteAll(Class<T> clazz, Connection connection) {
        String query = "DELETE FROM " + clazz.getSimpleName().toLowerCase() + "s";
        try {
            System.out.println("Silinen datalar => " + connection.createStatement().execute(query));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    default <T> boolean deleteById(Class<T> clazz, Connection connection, int id) {
        String query = "DELETE FROM " + clazz.getSimpleName().toLowerCase() + "s WHERE id=" + id;
        try {
            System.out.println("Silinen datalar => " + connection.createStatement().execute(query));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    default <T> List<T> findAll(Class<T> clazz, Connection connection) {
        String query = "SELECT * FROM " + clazz.getSimpleName().toLowerCase() + "s";
        Optional<ResultSet> allData;
        try {
            allData = Optional.ofNullable(connection.prepareStatement(query).executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (allData.isEmpty())
            return new ArrayList<>();
        List<T> list = new ArrayList<>();
        Method[] declaredMethods = clazz.getDeclaredMethods();

        try {
            while (allData.get().next()) {
                T obj = (T) clazz.getDeclaredConstructor().newInstance();
                for (Method method : declaredMethods) {
                    if (method.getName().contains("set")) {
                        switch (method.getGenericParameterTypes()[0].getTypeName()) {
                            case "int":
                                method.invoke(obj, allData.get().getInt(method.getName().replace("set", "")));
                                break;
                            case "long":
                                method.invoke(obj, allData.get().getLong(method.getName().replace("set", "")));
                                break;
                            case "java.lang.String":
                                method.invoke(obj, allData.get().getString(method.getName().replace("set", "")));
                                break;
                            case "java.util.Date":
                                method.invoke(obj, allData.get().getDate(method.getName().replace("set", "")));
                                break;
                        }
                    }
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    default <T> Optional<T> findById(Class<T> clazz, Connection connection, int id) {
        String query = "SELECT * FROM " + clazz.getSimpleName().toLowerCase() + "s WHERE id=" + id;
        Optional<ResultSet> allData;
        try {
            allData = Optional.ofNullable(connection.prepareStatement(query).executeQuery());
            if (allData.isEmpty())
                return Optional.empty();
            T obj = (T) clazz.getDeclaredConstructor().newInstance();
            if(!allData.get().next()){
                throw new RuntimeException("Yanlış id");
            }
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getName().contains("set")) {
                    switch (method.getGenericParameterTypes()[0].getTypeName()) {
                        case "int":
                            method.invoke(obj, allData.get().getInt(method.getName().replace("set", "")));
                            break;
                        case "long":
                            method.invoke(obj, allData.get().getLong(method.getName().replace("set", "")));
                            break;
                        case "java.lang.String":
                            method.invoke(obj, allData.get().getString(method.getName().replace("set", "")));
                            break;
                        case "java.util.Date":
                            method.invoke(obj, allData.get().getDate(method.getName().replace("set", "")));
                            break;
                    }
                }
            }

            return Optional.of(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
