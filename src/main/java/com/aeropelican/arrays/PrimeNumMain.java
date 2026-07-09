package com.aeropelican.arrays;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumMain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scn.nextInt();
        ArrayList<Integer> primeList = PrimeNumbers.printPrimes(num);
        System.out.println("Prime Numbers between 1 and : " + num + "are:" + primeList);
    }
        }

