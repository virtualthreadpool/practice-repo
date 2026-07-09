package com.aeropelican.arrays;

import java.util.ArrayList;

public class PrimeNumbers {
    public static ArrayList<Integer> printPrimes(int num) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
                            boolean isPrime = true;
                            for (int j = 2; j <= Math.sqrt(i); j++) {
                                if (i % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                            if (isPrime) {
                                primes.add(i);
                            }
                        }
                        return primes;
                    }
                }