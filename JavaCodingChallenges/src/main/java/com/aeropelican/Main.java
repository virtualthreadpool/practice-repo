package com.aeropelican;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Reverse a String");
            System.out.println("2. Prime Operations (Check )");
            System.out.println("3. Array Operations (Largest, Smallest, Sum)");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            if (choice == 4) {
                System.out.println("Exiting... Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    Reverse.execute(scanner);
                    break;
                case 2:
                    Prime.execute(scanner);
                    break;
                case 3:
                    handleArrayOperations(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Helper method to collect user array input and process operations
    private static void handleArrayOperations(Scanner scanner) {
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("\n--- Array Results ---");
        System.out.println("Largest Element: " + Largest.findLargest(array));
        System.out.println("Smallest Element: " + Smallest.findSmallest(array));
        System.out.println("Sum of Elements: " + Sum.calculateSum(array));
    }
}
