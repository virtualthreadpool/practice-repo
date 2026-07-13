package com.aeropelican.repositary;

import com.aeropelican.database.MYSQLConnection;
import com.aeropelican.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductRepository {
    public void addProduct(Product product) {

        try {

            Connection con = MYSQLConnection.getConnection();

            String sql = "INSERT INTO product(product_id, product_name, catregory, price, quantity) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getCategory());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getStock());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product inserted successfully.");
            } else {
                System.out.println("Product insertion failed.");
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }


    public void displayProducts() {

        try {

            Connection con = MYSQLConnection.getConnection();

            String sql = "SELECT * FROM products";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("product_id") + " "
                                + rs.getString("product_name") + " "
                                + rs.getString("category") + ""
                                + rs.getDouble("price") + " "
                                + rs.getInt("quantity"));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    public void updateProduct(Product product) {

        try {

            Connection con = MYSQLConnection.getConnection();

            String sql = "UPDATE product SET product_name=?, category=?, price=?, quantity=? WHERE product_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, product.getName());
            ps.setString(2, product.getCategory());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.setInt(5, product.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found.");
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }



    public void deleteProduct(int productId) {

        try {

            Connection con = MYSQLConnection.getConnection();

            String sql = "DELETE FROM product WHERE product_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, productId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product not found.");
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }



    }

    }

