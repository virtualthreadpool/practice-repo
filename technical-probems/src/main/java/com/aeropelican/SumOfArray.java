package com.aeropelican;
import java.util.Scanner;

public class SumOfArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        int sum = 0;

        System.out.println("Enter Array Elements:");

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
            sum += array[i];
        }

        System.out.println("Sum of Array Elements: " + sum);

        sc.close();
    }
}