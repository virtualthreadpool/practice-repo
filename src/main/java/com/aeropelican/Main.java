package com.aeropelican;

import com.aeropelican.model.Product;
import com.aeropelican.repository.Repository;

public class Main {

    public static void main(String[] args) {

        // Create Repository Object
        Repository repository = new Repository();

        // ===========================================
        // 1. INSERT A NEW PRODUCT
        // ===========================================
        System.out.println("========== INSERT PRODUCT ==========");

        Product product = new Product(106, "Speaker", 2500.00, 25);

        repository.addProduct(product);

        // ===========================================
        // 2. DISPLAY ALL PRODUCTS
        // ===========================================
        System.out.println("\n========== DISPLAY PRODUCTS ==========");

        repository.displayProducts();

        // ===========================================
        // 3. UPDATE PRODUCT
        // ===========================================
        System.out.println("\n========== UPDATE PRODUCT ==========");

        Product updatedProduct = new Product(106, "Bluetooth Speaker", 3000.00, 20);

        repository.updateProduct(updatedProduct);

        // ===========================================
        // 4. SEARCH PRODUCT BY ID
        // ===========================================
        System.out.println("\n========== SEARCH PRODUCT ==========");

        repository.searchProductById(106);

        // ===========================================
        // 5. DELETE PRODUCT
        // ===========================================
        System.out.println("\n========== DELETE PRODUCT ==========");

        repository.deleteProduct(106);

        // ===========================================
        // 6. DISPLAY PRODUCTS AFTER DELETE
        // ===========================================
        System.out.println("\n========== PRODUCTS AFTER DELETE ==========");

        repository.displayProducts();

        System.out.println("\n========== PROGRAM COMPLETED ==========");
    }
}