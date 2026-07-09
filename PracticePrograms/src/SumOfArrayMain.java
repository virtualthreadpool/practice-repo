import java.util.Scanner;

public class SumOfArrayMain {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Array Size: ");
        int n=sc.nextInt();

        int[] a=new int[n];
        System.out.println("Enter Array Elements: ");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        SumOfArray obj=new SumOfArray();
        obj.sum(a);
    }
}