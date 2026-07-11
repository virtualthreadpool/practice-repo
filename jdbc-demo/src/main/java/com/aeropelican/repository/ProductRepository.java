package com.aeropelican.repository;

import com.aeropelican.database.MySQLConnection;
import com.aeropelican.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductRepository {

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT product_id, product_name, category, price, stock_quantity FROM products";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("stock_quantity")
                );
                products.add(product);
            }
        }
        return products;
    }

    public HashMap<Integer, Product> getProductMap() throws SQLException {
        HashMap<Integer, Product> productMap = new HashMap<>();
        List<Product> products = getAllProducts();

        for (Product product : products) {
            productMap.put(product.getId(), product);
        }
        return productMap;
    }

    public void displayProducts() throws SQLException {
        List<Product> products = getAllProducts();

        System.out.println("------------- E-COMMERCE PRODUCTS ------------");
        for (Product p : products) {
            System.out.printf(
                    "ID: %d | Name: %-30s | Category: %-15s | Price: ₹%.2f | Stock: %d%n",
                    p.getId(), p.getName(), p.getCategory(), p.getPrice(), p.getStockQuantity()
            );
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    public boolean updateStock(int productId, int newStock) throws SQLException {
        String query = "UPDATE products SET stock_quantity = ? WHERE product_id = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, newStock);
            pstmt.setInt(2, productId);

            return pstmt.executeUpdate() > 0;
        }
    }
}