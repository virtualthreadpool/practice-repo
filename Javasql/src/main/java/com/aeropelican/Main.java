package com.aeropelican;

import com.aeropelican.exception.OutOfStockException;
import com.aeropelican.model.Product;
import com.aeropelican.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Welcome to Aeropelican E-Commerce Hub ---");

        List<Product> rawCatalog = repository.getAllProducts();
        Map<Integer, Product> productMap = new HashMap<>();
        for (Product p : rawCatalog) {
            productMap.put(p.getProductId(), p);
        }

        boolean running = true;
        while (running) {
            System.out.println("\n[1] View Catalog  |  [2] Buy Product  |  [3] Exit");
            System.out.print("Select an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> displayCatalog(productMap);
                case "2" -> handlePurchase(productMap, repository, scanner);
                case "3" -> {
                    System.out.println("Thank you for shopping with us!");
                    running = false;
                }
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
        scanner.close();
    }

    private static void displayCatalog(Map<Integer, Product> productMap) {
        System.out.printf("%n%-5s | %-40s | %-12s | %-8s%n", "ID", "Product Name", "Price", "Stock");
        System.out.println("--------------------------------------------------------------------------");
        productMap.values().forEach(item ->
                System.out.printf("%-5d | %-40s | $%-11.2f | %-8d%n",
                        item.getProductId(), item.getProductName(), item.getPrice(), item.getStockQuantity())
        );
    }

    private static void handlePurchase(Map<Integer, Product> productMap, ProductRepository repository, Scanner scanner) {
        try {
            System.out.print("Enter the Product ID you want to buy: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (!productMap.containsKey(id)) {
                System.out.println("Error: That Product ID does not exist in our catalog.");
                return;
            }

            Product selectedProduct = productMap.get(id);

            System.out.print("Enter quantity to buy: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            if (quantity <= 0) {
                System.out.println("Error: Quantity must be greater than 0.");
                return;
            }

            if (selectedProduct.getStockQuantity() < quantity) {
                throw new OutOfStockException("Insufficient stock! Only "
                        + selectedProduct.getStockQuantity() + " units available.");
            }

            Function<Integer, Double> costCalculator = qty -> selectedProduct.getPrice() * qty;
            double totalCost = costCalculator.apply(quantity);

            int remainingStock = selectedProduct.getStockQuantity() - quantity;
            selectedProduct.setStockQuantity(remainingStock);

            repository.updateStock(id, remainingStock);

            System.out.println("\n==================================");
            System.out.println("🎉 PURCHASE SUCCESSFUL! 🎉");
            System.out.println("Item: " + selectedProduct.getProductName());
            System.out.println("Quantity: " + quantity);
            System.out.printf("Total Charged: $%.2f%n", totalCost);
            System.out.println("==================================");

        } catch (NumberFormatException e) {
            System.out.println("Input Error: Please type numeric values for ID and Quantity fields.");
        } catch (OutOfStockException e) {
            System.out.println("Purchase Rejected: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected structural runtime error occurred.");
            e.printStackTrace();
        }
    }
}