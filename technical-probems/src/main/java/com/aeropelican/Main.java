package com.aeropelican;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringLogic s = new StringLogic();
        ArrayLogic a = new ArrayLogic();
        PrimeLogic p = new PrimeLogic();

        // Reverse String
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        s.reverse(str);

        // Array
        System.out.print("Enter Array Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter Elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        a.largest(arr);
        a.smallest(arr);
        a.sum(arr);

        // Prime Check
        System.out.print("Enter Number: ");
        int num = sc.nextInt();
        p.checkPrime(num);

        // Prime Range
        System.out.print("Enter Prime Range: ");
        int range = sc.nextInt();
        p.primeRange(range);
}
