package com.enes;

// Java12HibernateDB

import com.enes.entity.Musteri;
import com.enes.utility.HibernateUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

//        Musteri musteri1 = new Musteri("Berre", "Gül", "Dublin");
//        session.save(musteri1);

//        Musteri arananMusteri = session.get(Musteri.class, 2);
//        arananMusteri.setAd("Süleyman");
//        session.update(arananMusteri);

//        Musteri silinecekMusteri = session.get(Musteri.class, 2);
//        session.delete(silinecekMusteri);

        Criteria criteria = session.createCriteria(Musteri.class);
        List<Musteri> musteriList = criteria.list();

        transaction.commit();
        session.close();

        musteriList.forEach(System.out::println);

    }
}