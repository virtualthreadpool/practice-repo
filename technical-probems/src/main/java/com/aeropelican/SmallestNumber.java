package com.aeropelican;

public class SmallestNumber {
    public void findSmallest() {
        int[] arr = {989897,945476,987654,345676767,123456789,450000};
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        System.out.println("Smallest Number : " + smallest);
    }
}