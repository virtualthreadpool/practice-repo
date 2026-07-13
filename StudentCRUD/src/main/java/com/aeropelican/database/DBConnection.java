package com.aeropelican.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/StudentDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    public static Connection getConnection() {

        try {

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

}