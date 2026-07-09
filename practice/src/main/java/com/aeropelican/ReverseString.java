package com.aeropelican;

public class ReverseString {

    public void reverse(String str) {

        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        System.out.println("Reversed String: " + rev);
    }
}