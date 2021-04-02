package com.projects.onePointFive.servlet;

import com.projects.onePointFive.model.Reimbursement;
import com.projects.onePointFive.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstTomcatServlet extends HttpServlet {
    //car[] temp;
    User u = new User();
    Reimbursement r = new Reimbursement();

    public FirstTomcatServlet() {
        System.out.println("constructor of first");
    }

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("init in first");
        //temp = sqlFunctions.retrieveAllCarsIntoArray();
    }


    @Override
//    /user/12134
    // /reimbursement/21321356
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String i =  req.getParameter("user");
        //System.out.println(i);
        resp.getWriter().println("hi");
    }
}
