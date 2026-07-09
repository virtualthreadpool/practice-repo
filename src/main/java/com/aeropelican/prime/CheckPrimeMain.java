package com.aeropelican.prime;

import java.util.Scanner;
public class CheckPrimeMain {
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int num = scn.nextInt();
            if (CheckPrime.isPrime(num)) {
                System.out.println(num + " is a Prime Number.");
            } else {
                System.out.println(num + " is Not a Prime Number.");
            }

            scn.close();
        }
    }

