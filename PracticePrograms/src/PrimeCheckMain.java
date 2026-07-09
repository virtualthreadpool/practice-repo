import java.util.*;
public class PrimeCheckMain {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int num=sc.nextInt();

        PrimeCheck obj=new PrimeCheck();
        System.out.println(obj.isPrime(num));
    }
}