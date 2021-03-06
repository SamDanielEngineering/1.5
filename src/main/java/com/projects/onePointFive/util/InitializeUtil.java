package com.projects.onePointFive.util;

import com.projects.onePointFive.model.Reimbursement;
import com.projects.onePointFive.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class InitializeUtil {
    public Session init(){
        Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
        con.addAnnotatedClass(Reimbursement.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory();

        return 	sf.openSession();
    }
}
