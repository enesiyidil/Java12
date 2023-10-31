package com.enes.utility;

import com.enes.repository.entity.Musteri;
import com.sun.xml.bind.v2.model.core.ID;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyRepositoryFactory<T, ID> implements ICrud<T, ID>{

    private Session session;
    private Transaction transaction;

    Class<T> clazz;

    public MyRepositoryFactory(Class<T> clazz) {
        this.clazz = clazz;
    }

    private void openSession(){
        session = HibernateUtility.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    private void closeSession(){
        transaction.commit();
        session.close();
    }

    @Override
    public T save(T entity) {
        openSession();
        session.save(entity);
        closeSession();
        return entity;
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        openSession();
        entities.forEach(e -> session.save(e));
        closeSession();
        return entities;
    }

    @Override
    public void delete(T entity) {
        openSession();
        session.delete(entity);
        closeSession();
    }

    @Override
    public void deleteById(ID id) {
        openSession();
        session.delete(session.get(clazz, (Serializable) id));
        closeSession();
    }

    @Override
    public T update(T entity) {
        openSession();
//        session.update(entity);
        T updatedObj = (T) session.merge(entity);
        closeSession();
        return updatedObj;
    }

    @Override
    public Optional<T> findById(ID id) {
        openSession();
        Optional<T> obj = Optional.ofNullable(session.get(clazz, (Serializable) id));
        closeSession();
        return obj;
    }

    @Override
    public boolean existsById(ID id) {
        openSession();
        boolean present = findById(id).isPresent();
        closeSession();
        return present;
    }

    @Override
    public List<T> findAll() {
        openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<T> findByEntity(T entity) {
        openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        List<Predicate> pList = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            Object obj = null;
            try {
                obj = field.get(entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if(obj != null){
                Predicate p1 = null;
                switch (field.getType().getName()){
                    case "java.lang.String":
                        p1 = criteriaBuilder.like(root.get(field.getName()), (String) obj);
                }
                pList.add(p1);
            }
        }
        criteriaQuery.select(root).where(pList.toArray(new Predicate[0]));
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<T> findByColumnNameAndValue(String columnName, String value) {
        return null;
    }

    @Override
    public List<T> findByColumnNameAndValue(String columnName, Long value) {
        return null;
    }

    @Override
    public List<T> findByColumnNameAndValue(String columnName, BigDecimal value) {
        return null;
    }
}
