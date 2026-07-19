package com.aeropelican;
public class StringLogic{
    void reverse(String str){
        String rev="";
        for (int i=str.length()-1;i>=0;i--){
            rev=rev+str.charAt(i);
        }

        System.out.println("Reverse = "+rev);
    }
}