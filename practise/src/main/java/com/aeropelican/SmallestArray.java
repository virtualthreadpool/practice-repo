package com.aeropelican;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SmallestArray {
    public void smallest() {
        Scanner scanner = new Scanner(System.in);

        try {

        System.out.print("Enter array size: ");
        int n = scanner.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter Elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int min = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < min)
                min = arr[i];
        }

        System.out.println("Smallest Element: " + min);
        } catch  (InputMismatchException e){

            System.out.println("Invalid input! Please enter an integer for the array size.");

        }
    }
}
