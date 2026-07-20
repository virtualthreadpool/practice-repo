package com.aeropelican;

import java.util.Scanner;

public class CodingApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        WordLogic wordLogic = new WordLogic();
        NumberLogic numberLogic = new NumberLogic();
        ArrayLogic arrayLogic = new ArrayLogic();

        System.out.print("Enter a word to reverse: ");
        String word = scanner.nextLine();

        System.out.println("Reversed Word: " + wordLogic.reverseWord(word));

        System.out.print("\nEnter a number to check Prime: ");
        int number = scanner.nextInt();

        System.out.println("Prime Number: " + numberLogic.checkPrime(number));


        System.out.print("\nEnter the limit to print Prime Numbers: ");
        int limit = scanner.nextInt();

        System.out.print("Prime Numbers: ");
        numberLogic.displayPrimeNumbers(limit);

        System.out.print("\n\nEnter the size of the array: ");
        int size = scanner.nextInt();

        int[] values = new int[size];

        System.out.println("Enter " + size + " array elements:");

        for (int i = 0; i < size; i++) {
            values[i] = scanner.nextInt();
        }

        System.out.println("\nLargest Number: " + arrayLogic.findLargest(values));
        System.out.println("Smallest Number: " + arrayLogic.findSmallest(values));
        System.out.println("Sum of Array: " + arrayLogic.findSum(values));

        scanner.close();
    }
}