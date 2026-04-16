package com.giftson;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        First f1 = new First();
        f1.setAid(103);
        f1.setAname("telusko");
        f1.setTech("DEV OPS");

        Configuration config = new Configuration();
        config.addAnnotatedClass(First.class);

        config.configure("hibernate.cfg.xml");

        SessionFactory factory =config.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction =session.beginTransaction();
        session.persist(f1);  // save data


//        First f1=session.find(First.class,101);  // fetch data
//        System.out.println(f1);

//        session.merge(f1);  // update
//        transaction.commit();

//        System.out.println("updation done");

//            First f1 =session.find(First.class,103);
//            session.remove(f1);  // remove

        // commit nd close
        transaction.commit();
        session.close();
        factory.close();

    }
}
