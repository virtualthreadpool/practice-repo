package com.aeropelican;

import com.aeropelican.exception.InsufficientStockException;
import com.aeropelican.exception.ProductNotFoundException;
import com.aeropelican.service.ProductService;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProductService productService =
                new ProductService();

        boolean running = true;

        System.out.println(
                "======================================"
        );

        System.out.println(
                "   WELCOME TO E-COMMERCE STORE"
        );

        System.out.println(
                "======================================"
        );


        while (running) {

            System.out.println(
                    "\n1. View All Products"
            );

            System.out.println(
                    "2. Buy Product"
            );

            System.out.println(
                    "3. Exit"
            );

            System.out.print(
                    "\nEnter your choice: "
            );


            try {

                int choice = scanner.nextInt();


                switch (choice) {

                    case 1:

                        productService.showProducts();

                        break;


                    case 2:

                        System.out.print(
                                "Enter product ID: "
                        );

                        int productId =
                                scanner.nextInt();


                        System.out.print(
                                "Enter quantity: "
                        );

                        int quantity =
                                scanner.nextInt();


                        productService.buyProduct(
                                productId,
                                quantity
                        );

                        break;


                    case 3:

                        running = false;

                        System.out.println(
                                "\nThank you for using " +
                                        "the E-Commerce Store!"
                        );

                        break;


                    default:

                        System.out.println(
                                "\nInvalid choice. " +
                                        "Please select 1, 2, or 3."
                        );
                }


            } catch (
                    ProductNotFoundException |
                    InsufficientStockException e
            ) {

                System.out.println(
                        "\nError: " + e.getMessage()
                );


            } catch (
                    InputMismatchException e
            ) {

                System.out.println(
                        "\nInvalid input. " +
                                "Please enter numbers only."
                );

                scanner.nextLine();


            } catch (
                    IllegalArgumentException e
            ) {

                System.out.println(
                        "\nError: " + e.getMessage()
                );


            } catch (
                    SQLException e
            ) {

                System.out.println(
                        "\nDatabase error: "
                                + e.getMessage()
                );
            }
        }


        scanner.close();
    }
}