package com.aeropelican.repository;

import com.aeropelican.database.DBConnection;
import com.aeropelican.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Repository {


    // INSERT (CREATE)

    public void addProduct(Product product) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO product(product_id, product_name, price, quantity) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, product.getProductId());
            ps.setString(2, product.getProductName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQuantity());

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


    // SELECT ALL (READ)

    public void displayProducts() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM product";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("product_id") + " "
                                + rs.getString("product_name") + " "
                                + rs.getDouble("price") + " "
                                + rs.getInt("quantity"));

            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    // UPDATE

    public void updateProduct(Product product) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE product SET product_name=?, price=?, quantity=? WHERE product_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setInt(4, product.getProductId());

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


    // DELETE

    public void deleteProduct(int productId) {

        try {

            Connection con = DBConnection.getConnection();

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

    public void searchProductById(int productId) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM product WHERE product_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Product Found");

                System.out.println("Product ID   : " + rs.getInt("product_id"));
                System.out.println("Product Name : " + rs.getString("product_name"));
                System.out.println("Price        : " + rs.getDouble("price"));
                System.out.println("Quantity     : " + rs.getInt("quantity"));

            } else {

                System.out.println("Product not found.");

            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}