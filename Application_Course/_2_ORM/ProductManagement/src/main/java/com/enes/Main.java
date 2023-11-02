package com.enes;

import com.enes.app.Menu;

public class Main {
    public static void main(String[] args) {

//        Session session = HibernateUtility.getSessionFactory().openSession();
//        session.close();

        Menu menu = new Menu();
        menu.menu();
    }
}