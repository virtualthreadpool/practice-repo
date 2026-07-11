package com.aeropelican.repository;

import com.aeropelican.database.MySQLConnection;
import com.aeropelican.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("category_id"),
                        rs.getDouble("price"),
                        rs.getInt("stock_quantity"),
                        rs.getString("sku"),
                        rs.getTimestamp("created_at")
                );
                products.add(product);
            }
        } catch (Exception e) {
            System.err.println("Error fetching products from database!");
            e.printStackTrace();
        }
        return products;
    }

    public void updateStock(int productId, int newStock) {
        String query = "UPDATE products SET stock_quantity = ? WHERE product_id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, newStock);
            pstmt.setInt(2, productId);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("Failed to update database stock level.");
            e.printStackTrace();
        }
    }
}