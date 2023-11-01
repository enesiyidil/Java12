package com.enes.utility;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyRepositoryFactory<T, ID> implements ICrud<T, ID> {

    private Session session;
    private Transaction transaction;

    Class<T> clazz;

    public MyRepositoryFactory(Class<T> clazz) {
        this.clazz = clazz;
    }

    private void openSession() {
        session = HibernateUtility.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    private void closeSession() {
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
        return findById(id).isPresent();
    }

    @Override
    public List<T> findAll() {
        openSession();
        List<T> resultList = session.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
        closeSession();
        return resultList;
    }

    @Override
    public List<T> findByEntity(T entity) {
        openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        List<Predicate> pList = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true); // Erişime açmak için
            Object obj = null;
            try {
                obj = field.get(entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (obj != null) {
                if(field.getType().isAssignableFrom(Number.class)){
                    System.out.println("-");
                }
                Predicate p1 = switch (field.getType().getName()) {
                    case "java.lang.String" -> criteriaBuilder.like(root.get(field.getName()), (String) obj);
                    case "java.lang.Long", "java.math.BigDecimal", "java.lang.Integer" ->
                            criteriaBuilder.equal(root.get(field.getName()), obj);
                    default -> null;
                };
                pList.add(p1);
            }
        }
        criteriaQuery.select(root).where(pList.toArray(new Predicate[0]));
        return session.createQuery(criteriaQuery).getResultList();
    }

    public List<T> findByEntity2(T entity) {
        return findByCondition((criteriaBuilder, root) -> {
            List<Predicate> pList = new ArrayList<>();
            for (Field field : clazz.getDeclaredFields()) {
                Object obj = null;
                try {
                    obj = field.get(entity);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (obj != null) {
                    Predicate p1 = switch (field.getType().getName()) {
                        case "java.lang.String" -> criteriaBuilder.like(root.get(field.getName()), (String) obj);
                        case "java.lang.Long", "java.math.BigDecimal", "java.lang.Integer" ->
                                criteriaBuilder.equal(root.get(field.getName()), obj);
                        default -> null;
                    };
                    pList.add(p1);
                }
            }
            return criteriaBuilder.or(pList.toArray(new Predicate[0]));
        });
    }

    @Override
    public <E> List<T> findByColumnNameAndValue(String columnName, E value) {
        try {
            T entity = clazz.getDeclaredConstructor().newInstance();
            String methodName = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
            clazz.getDeclaredMethod(methodName, value.getClass()).invoke(entity, value);
            return findByEntity(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <E> List<T> findByColumnNameAndValue2(String columnName, E value) {
        openSession();
        List<T> resultList = session.createQuery("FROM " + clazz.getSimpleName() + " WHERE " + columnName + " = :value", clazz)
                .setParameter("value", value).getResultList();
        closeSession();
        return resultList;
    }

    @Override
    public List<T> findByCondition(Function<CriteriaBuilder, Root<T>, Predicate> condition) {
        openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(condition.apply(criteriaBuilder, root));
        return session.createQuery(criteriaQuery).getResultList();
    }

}
