import java.util.Scanner;

public class PrimeArrayMain {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Prime Range Number: ");
        int n=sc.nextInt();

        PrimeArray obj=new PrimeArray();
        obj.Primerange(n);
    }
}