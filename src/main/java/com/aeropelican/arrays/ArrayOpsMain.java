package com.aeropelican.arrays;
public class ArrayOpsMain {
        public static void main(String[] args) {
            int[] arr = {6, 2, 3, 1, 5, 7};
            int largest = ArrayOperations.largest(arr);
            int smallest = ArrayOperations.smallest(arr);
            int sum = ArrayOperations.findSum(arr);
            System.out.println("Largest Number  in array : " + largest);
            System.out.println("Smallest Number in array : " + smallest);
            System.out.println("Sum of Elements: " + sum);
        }
    }
