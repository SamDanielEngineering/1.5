package com.projects.onePointFive;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class driver {
    public static void main(String[] args) {
        Alien help = new Alien();
        help.setAid(100);
        help.setAname("bob");
        help.setColor("Blue");

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);


        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(help);

        tx.commit();

    }


}
