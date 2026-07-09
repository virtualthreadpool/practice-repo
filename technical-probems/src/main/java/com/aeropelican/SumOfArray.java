package com.aeropelican;

public class SumOfArray {
    public void findSum() {
        int[] arr = {888,9999,10000,575764,44455566,356743,1,98,3,7};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println("Sum of Array : " + sum);
    }
}