package com.aeropelican;
import java.util.Scanner;

public class PrimeNumbersBetween1AndN {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        System.out.println("Prime Numbers:");

        for (int number = 2; number <= n; number++) {

            boolean isPrime = true;

            for (int i = 2; i <= number / 2; i++) {

                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(number + " ");
            }
        }

        sc.close();
    }
}