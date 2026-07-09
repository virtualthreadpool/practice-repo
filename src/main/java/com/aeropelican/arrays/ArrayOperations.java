package com.aeropelican.arrays;

public class ArrayOperations {
        public static int largest(int[] arr) {
            int largest = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > largest) {
                    largest = arr[i];
                }
            }
            return largest;
        }
        public static int smallest(int[] arr) {
            int smallest = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < smallest) {
                    smallest = arr[i];
                }
            }
            return smallest;
        }
        public static int findSum(int[] arr) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }

