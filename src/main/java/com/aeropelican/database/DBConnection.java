package com.aeropelican.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {


    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";


    private static final String USER = "root";


    private static final String PASSWORD = "Gurubalaji@182510";


    public static Connection getConnection() {

        Connection con = null;

        try {


            Class.forName("com.mysql.cj.jdbc.Driver");


            con = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {

            System.out.println("Database Connection Failed!");
            e.printStackTrace();

        }

        return con;
    }
}