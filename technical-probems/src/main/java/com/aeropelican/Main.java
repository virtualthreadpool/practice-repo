package com.aeropelican;

public class Main {

    public static void main(String[] args) {

        ReverseString reverse = new ReverseString();
        reverse.reverse();

        PrimeNumber prime = new PrimeNumber();
        prime.checkPrime();

        PrimeNumbersBetween primes = new PrimeNumbersBetween();
        primes.printPrimes();

        LargestNumber largest = new LargestNumber();
        largest.findLargest();

        SmallestNumber smallest = new SmallestNumber();
        smallest.findSmallest();

        SumOfArray sum = new SumOfArray();
        sum.findSum();
    }
}