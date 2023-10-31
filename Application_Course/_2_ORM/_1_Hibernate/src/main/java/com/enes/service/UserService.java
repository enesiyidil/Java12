package com.enes.service;

import com.enes.entity.Address;
import com.enes.entity.Information;
import com.enes.entity.User;
import com.enes.enums.EAddressType;
import com.enes.enums.EGender;
import com.enes.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    public void save(){
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
                .build();
        session.save(user);

        transaction.commit();
        session.close();
    }
}
