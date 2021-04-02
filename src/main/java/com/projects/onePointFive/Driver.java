package com.projects.onePointFive;


import com.projects.onePointFive.model.Reimbursement;
import com.projects.onePointFive.model.User;
import com.projects.onePointFive.util.InitializeUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Driver {
    public static void main(String[] args) {
        User u = new User(1,"user1","pass",
                "Elizabeth","Ye", "elizabeth.ye@revature.net",2);

        InitializeUtil i = new InitializeUtil();
        i.init();

        Session session = i.init();

        Transaction tx = session.beginTransaction();

        session.save(u);

        tx.commit();

    }


}
