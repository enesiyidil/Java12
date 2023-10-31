package com.enes.utility;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ICrud<T, ID> {

    T save(T entity);

    Iterable<T> saveAll(Iterable<T> entities);

    void delete(T entity);

    void deleteById(ID id);

    T update(T entity);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    List<T> findAll();

    /**
     *
     */
    List<T> findByEntity(T entity);

    List<T> findByColumnNameAndValue(String columnName, String value);

    List<T> findByColumnNameAndValue(String columnName, Long value);

    List<T> findByColumnNameAndValue(String columnName, BigDecimal value);

}
