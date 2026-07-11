package com.aeropelican.repo;
import com.aeropelican.databaseconnection.SqlConnection;

import com.aeropelican.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductRepository {

    public void addProduct(Product product) {

        String sql = "INSERT INTO product(name,price,quantity) VALUES(?,?,?)";

        try {
            Connection con = SqlConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());

            ps.executeUpdate();

            System.out.println("Product Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewProducts() {

        String sql = "SELECT * FROM product";

        try {
            Connection con = SqlConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("------------------");
                System.out.println("Id : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Price : " + rs.getDouble("price"));
                System.out.println("Quantity : " + rs.getInt("quantity"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}