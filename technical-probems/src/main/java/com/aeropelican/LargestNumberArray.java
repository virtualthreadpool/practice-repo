package com.aeropelican;
import java.util.Scanner;

public class LargestNumberArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter Array Elements:");

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int largest = array[0];

        for (int i = 1; i < size; i++) {

            if (array[i] > largest) {
                largest = array[i];
            }
        }

        System.out.println("Largest Number: " + largest);

        sc.close();
    }
}