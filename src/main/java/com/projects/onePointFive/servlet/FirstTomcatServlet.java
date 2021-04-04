package com.projects.onePointFive.servlet;


import com.google.gson.Gson;
import com.projects.onePointFive.model.Reimbursement;
import com.projects.onePointFive.model.User;
import com.projects.onePointFive.service.ReimbursementService;
import com.projects.onePointFive.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class FirstTomcatServlet extends HttpServlet {
    ReimbursementService rs = new ReimbursementService();
    UserService us = new UserService();

    public FirstTomcatServlet() {
        System.out.println("constructor of first");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init in first");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userID = 0;
        int reimbursementID = 0;
        String username = null;
        String password = null;
        boolean fetchAllUsers = false;
        boolean fetchAllReimbursements = false;

        if (req.getParameter("userID") != null)
            userID = Integer.parseInt(req.getParameter("userID"));
        if (req.getParameter("username") != null)
            username = req.getParameter("username");
        if (req.getParameter("password") != null)
            password = req.getParameter("password");
        if (req.getParameter("reimbursementID") != null)
            reimbursementID = Integer.parseInt(req.getParameter("reimbursementID"));
        if (req.getParameter("fetchAll") != null) {
            if (req.getParameter("fetchAll").equals("Users"))
                fetchAllUsers = true;
            if (req.getParameter("fetchAll").equals("Reimbursements"))
                fetchAllReimbursements = true;
        }


        if (userID != 0) {
            User u = us.getUserById(userID);
            resp.getWriter().println(u.toString());
        }
        else if (username != null && password != null) {
            User u = us.getUserByLogin(username, password);
            resp.getWriter().println(u.toString());
        }
        else if (username != null) {
            User u = us.getUserByUsername(username);
            resp.getWriter().println(u.toString());
        }
        else if (reimbursementID != 0){
            List l = rs.getReimbursementsByUserID(reimbursementID);
            for (int i = 0; i < l.size(); i++) {
                resp.getWriter().println(l.get(i).toString());
            }
        }
        else if (fetchAllUsers == true){
            List l = us.fetchAllUsers();

            for (int i = 0; i < l.size(); i++){
                resp.getWriter().println(l.get(i).toString());
            }
        }
        else if (fetchAllReimbursements == true){
            List l = rs.fetchAllReimbursements();

            for (int i = 0; i < l.size(); i++){
                resp.getWriter().println(l.get(i).toString());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        String clazz = clazz = req.getParameter("class");
        User u = null;
        Reimbursement r = null;
        Boolean update = false;

        if (req.getParameter("update") != null){
            if (req.getParameter("update").equals("true"))
                update = true;
        }

        if (clazz.equals("Reimbursement") && update){
            r = gson.fromJson(reader, Reimbursement.class);

            rs.update(r, r.getId());
        }

        else if (clazz != null && !update) {
            if (clazz.equals("User")) {
                u = gson.fromJson(reader, User.class);
                us.createUser(u);
            }
            else if (clazz.equals("Reimbursement")) {
                r = gson.fromJson(reader, Reimbursement.class);
                rs.sendNewReimbursement(r);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp){
        int userID = 0;
        int reimbursementID = 0;

        if (req.getParameter("user") != null){
            userID = Integer.parseInt(req.getParameter("user"));
            us.deleteUser(userID);
        }
        else if (req.getParameter("reimbursement") != null){
            reimbursementID = Integer.parseInt(req.getParameter("reimbursement"));
            rs.deleteReimbursement(reimbursementID);
        }
    }
}
