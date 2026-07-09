package com.aeropelican.strings;

import java.util.Scanner;

public class ReverseMain {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a string to reverse: ");
        String str = scn.nextLine();
        String result =ReverseString.reverse(str);
        System.out.println("Original String: "+str);
        System.out.println("Reverse String: "+result);
    }
}
