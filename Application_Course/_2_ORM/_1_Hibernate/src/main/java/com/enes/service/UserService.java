package com.enes.service;

import com.enes.entity.Address;
import com.enes.entity.Information;
import com.enes.entity.User;
import com.enes.enums.EAddressType;
import com.enes.enums.EGender;
import com.enes.utility.HibernateUtility;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

public class UserService {

    CriteriaBuilder criteriaBuilder;
    public void save() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Map<EAddressType, Address> addresses = new HashMap<>();
        addresses.put(EAddressType.HOME, Address.builder()
                .country("Türkiye")
                .city("İstanbul")
                .street("Cadde")
                .build());
        User user = User.builder()
                .password("12345")
                .username("mehmet")
                .information(Information.builder()
                        .name("Mehmet")
                        .middlename("Ali")
                        .surname("Yardımcı")
                        .build())
                .gender(EGender.MALE)
                .addresses(addresses)
                .interests(Arrays.asList("Kitap", "Deniz"))
                .build();
        Map<EAddressType, Address> addresses2 = new HashMap<>();
        addresses2.put(EAddressType.HOME, Address.builder()
                .country("ABD")
                .city("NewYork")
                .street("XX15")
                .build());
        User user2 = User.builder()
                .password("665522")
                .username("test")
                .information(Information.builder()
                        .name("Test")
                        .middlename("est")
                        .surname("TT")
                        .build())
                .gender(EGender.MALE)
                .addresses(addresses2)
                .interests(Arrays.asList("Film", "Sal"))
                .build();

        List<String> interests3 = Arrays.asList("Software", "Dergi");

        Map<EAddressType, Address> adres3 = new HashMap<>();
        adres3.put(EAddressType.HOME, Address.builder()
                .country("İspanya")
                .city("Madrid")
                .street("YStreet")
                .build());
        Information information3 = Information.builder()
                .surname("yaz")
                .middlename("mahmut")
                .name("serkan")
                .build();
        User user3 = User.builder()
                .password("123456")
                .username("serko")
                .information(information3)
                .interests(interests3)
                .addresses(adres3)
                .build();
        session.save(user);
        session.save(user2);
        session.save(user3);

        transaction.commit();
        session.close();
    }

    private Session session;
    private Transaction transaction;

    private void openSession() {
        session = HibernateUtility.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        criteriaBuilder = session.getCriteriaBuilder();
    }

    private void closeSession() {
        transaction.commit();
        session.close();
    }

    /*
     * 1- findAll                   --> List<User>
     * 2- findAllInformation        --> List<Information>
     * 3- findAllInformationName    --> List<String>
     * 4- findById                  --> User
     */

    public List<User> findAll() {
        openSession();
        List<User> resultList = session.createQuery("FROM " + User.class.getSimpleName(), User.class).getResultList();
        resultList.stream().forEach(user -> {
            Hibernate.initialize(user.getAddresses());
            Hibernate.initialize(user.getInterests());
        });
        closeSession();
        return resultList;
    }

    public List<Information> findAllInformation() {
        return findAll().stream().map(User::getInformation).collect(Collectors.toList());
    }

    public List<String> findAllInformationName() {
        return findAll().stream().map(user -> user.getInformation().getName()).collect(Collectors.toList());
    }

    public Optional<User> findById(Long id) {
        openSession();
        Optional<User> obj = Optional.ofNullable(session.get(User.class, id));
        closeSession();
        return obj;
    }

    public List<User> deneme(){
        openSession();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        root.fetch("posts", JoinType.INNER);
//        Join<User, Post> join = root.join("posts");
//        join.on(criteriaBuilder.equal(root.get("id"), join.get("userid")));
        query.select(root);
        return session.createQuery(query).getResultList();
    }
}
