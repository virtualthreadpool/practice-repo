package com.aeropelican;

public class Sum {
    public static int calculateSum(int[] array) {
        int total = 0;
        for (int num : array) {
            total += num;
        }
        return total;
    }
}