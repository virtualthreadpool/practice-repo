import java.util.Scanner;
public class ReverseStringMain{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str=sc.nextLine();

        ReverseString obj=new ReverseString();

        String result=obj.reverse(str);
        System.out.println("Reversed String: "+result);
    }
}