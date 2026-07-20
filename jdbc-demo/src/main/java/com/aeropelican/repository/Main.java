package com.aeropelican.repository;

import com.aeropelican.exception.InsufficientStockException;
import com.aeropelican.exception.ProductNotFoundException;
import com.aeropelican.model.Product;
import com.aeropelican.service.ProductService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();
        Scanner sc = new Scanner(System.in);

        try {
            service.showProducts();

            HashMap<Integer, Product> productMap = service.loadProducts();

            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Buy product");
                System.out.println("2. View all products");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Product ID: ");
                        int productId = sc.nextInt();

                        if (!productMap.containsKey(productId)) {
                            System.out.println("Invalid product ID. Please try again.");
                            break;
                        }

                        Product selectedProduct = productMap.get(productId);
                        System.out.println("Selected: " + selectedProduct);

                        System.out.print("Enter quantity to buy: ");
                        int quantity = sc.nextInt();

                        try {
                            service.buyProduct(productId, quantity);
                            productMap = service.loadProducts();
                        } catch (ProductNotFoundException | InsufficientStockException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Input Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        service.showProducts();
                        break;

                    case 3:
                        System.out.println("Thank you for shopping.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please select 1, 2, or 3.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}