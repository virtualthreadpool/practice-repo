package com.aeropelican;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ReverseString s = new ReverseString();
        Array a = new Array();
        Prime p = new Prime();

        // Reverse String
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        s.reverse(str);

        // Array
        System.out.print("\nEnter Array Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter Array Elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        a.largest(arr);
        a.smallest(arr);
        a.sum(arr);

        // Prime Check
        System.out.print("\nEnter Number to Check Prime: ");
        int num = sc.nextInt();
        p.checkPrime(num);

        // Prime Range
        System.out.print("\nEnter Range: ");
        int range = sc.nextInt();
        p.primeRange(range);

        sc.close();
    }
}