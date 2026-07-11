package com.aeropelican.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;

    public class SqlConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "12345678"; // or "1234" if that's your password

        public static Connection getConnection() {
            try {
                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }


        }

