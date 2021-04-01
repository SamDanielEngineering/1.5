package com.projects.onePointFive.dao;

import com.projects.onePointFive.util.InitializeUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoTestCases {

    @Test
    @Order(1)
    public void getUserList(){

    }

    @Test
    @Order(2)
    public void getUserById(){

    }

    @Test
    @Order(3)
    public void getUserListByUserId(){

    }

    @Test
    @Order(4)
    public void getUserByUsername(){

    }

    @Test
    @Order(5)
    public void insertUser(){

    }

    @Test
    @Order(6)
    public void deleteUser(){

    }
}
