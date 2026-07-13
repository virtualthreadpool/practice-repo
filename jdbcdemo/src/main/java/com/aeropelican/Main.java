package com.aeropelican;

import com.aeropelican.model.Product;
import com.aeropelican.repositary.ProductRepository;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();


        System.out.println("========== INSERT PRODUCT ==========");

        Product product = new Product(106, "jbl", "speaker",1500, 30);

        repository.addProduct(product);


        System.out.println("\n========== DISPLAY PRODUCTS ==========");

        repository.displayProducts();



        System.out.println("\n========== UPDATE PRODUCT ==========");

        Product updatedProduct = new Product(106, "jbl", "speaker", 1500,30);

        repository.updateProduct(updatedProduct);



        System.out.println("\n========== DELETE PRODUCT ==========");

        repository.deleteProduct(106);

        System.out.println("\n====== PRODUCTS AFTER DELETE ====");

        repository.displayProducts();

        System.out.println("\n=== PROGRAM COMPLETED =====");
    }
}
