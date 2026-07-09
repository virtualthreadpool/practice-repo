package com.aeropelican;

public class PrimeNumbersBetween {
    public void printPrimes() {
        int n = 100;
        System.out.print("Prime Numbers : ");
        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}