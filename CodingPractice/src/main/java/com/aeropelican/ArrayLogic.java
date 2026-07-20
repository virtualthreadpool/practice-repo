package com.aeropelican;

public class ArrayLogic {

    public int findLargest(int[] values) {

        int largest = values[0];

        for (int value : values) {

            if (value > largest) {
                largest = value;
            }
        }

        return largest;
    }

    public int findSmallest(int[] values) {

        int smallest = values[0];

        for (int value : values) {

            if (value < smallest) {
                smallest = value;
            }
        }

        return smallest;
    }

    public int findSum(int[] values) {

        int total = 0;

        for (int value : values) {
            total += value;
        }

        return total;
    }
}