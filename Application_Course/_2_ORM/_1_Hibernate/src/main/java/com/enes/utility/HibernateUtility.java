package com.enes.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private static SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.addPackage("com.enes.entity");
            SESSION_FACTORY = configuration.configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Hibernate SessionFactory'de hata! " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory(){
        return  SESSION_FACTORY;
    }
}
