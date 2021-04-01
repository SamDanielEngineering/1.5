package com.projects.onePointFive.dao;

import com.projects.onePointFive.util.InitializeUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReimbursementDaoTestCases {
    public class UserDaoTestCases {
        @Test
        @Order(1)
        public void getReimbursementList(){

        }

        @Test
        @Order(2)
        public void getReimbursementById(){

        }

        @Test
        @Order(3)
        public void getListOfUsersReimbursements(){

        }

        @Test
        @Order(4)
        public void insertReimbursement(){

        }

        @Test
        @Order(5)
        public void updateReimbursementList(){

        }

        @Test
        @Order(6)
        public void deleteReimbursement(){

        }
    }
}
