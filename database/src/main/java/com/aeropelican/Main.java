package com.aeropelican;

import com.aeropelican.model.Product;
import com.aeropelican.repo.ProductRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductRepository repository = new ProductRepository();

        int choice;

        do {

            System.out.println("\n===== E-Commerce System =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    Product product = new Product();

                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    product.setName(sc.nextLine());

                    System.out.print("Enter Product Price: ");
                    product.setPrice(sc.nextDouble());

                    System.out.print("Enter Product Quantity: ");
                    product.setQuantity(sc.nextInt());

                    repository.addProduct(product);

                    break;

                case 2:

                    repository.viewProducts();

                    break;

                case 3:

                    System.out.println("Thank You...");
                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 3);

        sc.close();
    }
}