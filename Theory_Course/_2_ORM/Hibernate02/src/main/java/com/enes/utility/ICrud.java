package com.enes.utility;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    List<T> findByEntity(T entity);

    <E> List<T> findByColumnNameAndValue(String columnName, E value);

    List<T> findByCondition(Function<CriteriaBuilder, Root<T>, Predicate> condition);

}
