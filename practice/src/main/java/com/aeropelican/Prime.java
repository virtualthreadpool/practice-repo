package com.aeropelican;

public class Prime {
        void checkPrime(int n){
            int count=0;

            for (int i=1;i<=n;i++){
                if (n%i==0)
                    count++;
            }
            if (count==2)
                System.out.println("True");
            else
                System.out.println("False");
        }

        void primeRange(int n){
            int[] a=new int[n];
            int k=0;

            for (int i=2;i<=n;i++){
                int count=0;
                for (int j=1;j<=i;j++){
                    if (i%j==0)
                        count++;
                }
                if (count==2){
                    a[k]=i;
                    k++;
                }
            }
            for (int i=0;i<k;i++){
                System.out.print(a[i] + " ");
            }
        }
    }

