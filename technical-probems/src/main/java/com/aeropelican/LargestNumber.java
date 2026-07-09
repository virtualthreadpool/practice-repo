package com.aeropelican;

public class LargestNumber {
    public void findLargest() {
        int[] arr = {98,47,999,1008,15765,422437,45464789};
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        System.out.println("Largest Number : " + largest);
    }
}