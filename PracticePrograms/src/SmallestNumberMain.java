import java.util.Scanner;

public class SmallestNumberMain {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n=sc.nextInt();

        int[] a=new int[n];

        System.out.println("Enter Array Elements: ");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        SmallestNumber obj=new SmallestNumber();
        obj.smallest(a);
    }
}