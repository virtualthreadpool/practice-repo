package com.aeropelican;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SumArray {
    public void sum() {
        Scanner scanner = new Scanner(System.in);

        try {

        System.out.print("Enter array size: ");
        int n = scanner.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter Elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }

        System.out.println("Sum of Elements: " + sum);

        } catch  (InputMismatchException e){

            System.out.println("Invalid input! Please enter an integer for the array size.");

        }
    }
}
