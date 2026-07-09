package com.aeropelican;

import java.util.Scanner;

public class Prime {
    public static void execute(Scanner scanner) {
        System.out.print("Enter a number to check prime: ");
        int num = scanner.nextInt();

        if (num <= 1) {
            System.out.println(num + " is NOT a prime number.");
        } else {
            boolean isPrime = true;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is NOT a prime number.");
            }
        }
    }
}