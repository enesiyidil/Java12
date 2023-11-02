package com.enes.utility;

import com.enes.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private static SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration();

            configuration.addPackage("com.enes.entity.*");
            configuration.addAnnotatedClass(Admin.class);
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(ProductDetail.class);
            configuration.configure();
            SESSION_FACTORY = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Hibernate SessionFactory'de hata! " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory(){
        return  SESSION_FACTORY;
    }
}
