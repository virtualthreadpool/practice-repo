package com.aeropelican.service;

import com.aeropelican.exception.InsufficientStockException;
import com.aeropelican.exception.ProductNotFoundException;
import com.aeropelican.model.Product;
import com.aeropelican.repository.ProductRepository;

import java.sql.SQLException;
import java.util.HashMap;

public class ProductService {

    private final ProductRepository repository =
            new ProductRepository();


    public HashMap<Integer, Product> loadProducts()
            throws SQLException {

        return repository.getProductMap();
    }


    public void showProducts()
            throws SQLException {

        repository.displayProducts();
    }


    public void buyProduct(
            int productId,
            int quantity
    ) throws SQLException,
            ProductNotFoundException,
            InsufficientStockException {

        HashMap<Integer, Product> productMap =
                repository.getProductMap();

        Product product =
                productMap.get(productId);


        if (product == null) {

            throw new ProductNotFoundException(
                    "Product not found with ID: "
                            + productId
            );
        }


        if (quantity <= 0) {

            throw new IllegalArgumentException(
                    "Quantity must be greater than zero."
            );
        }


        if (product.getStockQuantity() < quantity) {

            throw new InsufficientStockException(

                    "Insufficient stock. Available: "
                            + product.getStockQuantity()
                            + ", Requested: "
                            + quantity
            );
        }


        int updatedStock =
                product.getStockQuantity() - quantity;


        boolean updated =
                repository.updateStock(
                        productId,
                        updatedStock
                );


        if (!updated) {

            throw new SQLException(

                    "Stock update failed for product ID: "
                            + productId
            );
        }


        System.out.println(
                "\nPurchase successful!"
        );

        System.out.println(
                "Product: " + product.getName()
        );

        System.out.println(
                "Quantity bought: " + quantity
        );

        System.out.println(
                "Remaining stock: " + updatedStock
        );
    }
}