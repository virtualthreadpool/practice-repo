package com.aeropelican;

import java.util.Scanner;

public class Reverse {
    public static void execute(Scanner scanner) {
        System.out.print("Enter a string to reverse: ");
        scanner.nextLine();
        String input = scanner.nextLine();

        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("Reversed string: " + reversed);
    }
}