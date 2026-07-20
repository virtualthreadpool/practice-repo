package com.aeropelican;

public class NumberLogic {

    public boolean checkPrime(int number) {

        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public void displayPrimeNumbers(int limit) {

        for (int i = 2; i <= limit; i++) {

            if (checkPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}