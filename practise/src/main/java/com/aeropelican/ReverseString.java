package com.aeropelican;

import java.util.Scanner;

public class ReverseString {
    public void reverse(){
        Scanner scanner =new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        StringBuilder stringbuilder = new StringBuilder(string);

        stringbuilder.reverse();

        System.out.println("Reversed string: " + stringbuilder);
    }
}
