package com.enes.utility;

import com.enes.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private static SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration();
            //configuration.addAnnotatedClass(User.class);
            SESSION_FACTORY = configuration.configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Hibernate SessionFactory'de hata! " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory(){
        return  SESSION_FACTORY;
    }
}
