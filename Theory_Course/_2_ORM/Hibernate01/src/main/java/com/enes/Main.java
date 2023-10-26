package com.enes;

// Java12HibernateDB

import com.enes.entity.Musteri;
import com.enes.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Musteri musteri1 = new Musteri("Ozan", "Çelik", "London");
        session.save(musteri1);

        transaction.commit();
        session.close();
    }
}