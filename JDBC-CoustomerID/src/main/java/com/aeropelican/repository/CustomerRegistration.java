package main.java.com.aeropelican.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CustomerRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Customer customer = new Customer(id, name, email, phone, password);

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO customers VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getCustomerName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getPassword());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Registered Successfully!");
            } else {
                System.out.println("Registration Failed!");
            }

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}