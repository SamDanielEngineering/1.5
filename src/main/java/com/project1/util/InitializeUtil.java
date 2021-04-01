package com.project1.util;

import com.project1.model.Reimbursement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class InitializeUtil {
    public Session init(){
        Configuration con = new Configuration().configure().addAnnotatedClass(Reimbursement.class);


        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory();

        return 	sf.openSession();

    }
}
