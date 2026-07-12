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

        String query =
                "SELECT product_id, product_name, category, " +
                        "price, stock_quantity FROM products";

        try (
                Connection connection =
                        MySQLConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query);

                ResultSet resultSet =
                        preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {

                Product product = new Product(

                        resultSet.getInt("product_id"),

                        resultSet.getString("product_name"),

                        resultSet.getString("category"),

                        resultSet.getDouble("price"),

                        resultSet.getInt("stock_quantity")
                );

                products.add(product);
            }
        }

        return products;
    }


    public HashMap<Integer, Product> getProductMap()
            throws SQLException {

        HashMap<Integer, Product> productMap =
                new HashMap<>();

        List<Product> products = getAllProducts();

        for (Product product : products) {

            productMap.put(
                    product.getId(),
                    product
            );
        }

        return productMap;
    }


    public void displayProducts()
            throws SQLException {

        List<Product> products = getAllProducts();

        System.out.println(
                "\n---------------- E-COMMERCE PRODUCTS ----------------"
        );

        for (Product product : products) {

            System.out.printf(

                    "ID: %-5d | Name: %-30s | " +
                            "Category: %-20s | Price: ₹%.2f | " +
                            "Stock: %d%n",

                    product.getId(),

                    product.getName(),

                    product.getCategory(),

                    product.getPrice(),

                    product.getStockQuantity()
            );
        }

        System.out.println(
                "-----------------------------------------------------"
        );
    }


    public boolean updateStock(
            int productId,
            int newStock
    ) throws SQLException {

        String query =
                "UPDATE products " +
                        "SET stock_quantity = ? " +
                        "WHERE product_id = ?";

        try (
                Connection connection =
                        MySQLConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {

            preparedStatement.setInt(
                    1,
                    newStock
            );

            preparedStatement.setInt(
                    2,
                    productId
            );

            return preparedStatement.executeUpdate() > 0;
        }
    }
}