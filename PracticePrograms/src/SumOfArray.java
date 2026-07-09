public class SumOfArray {
    void sum(int a[]){
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum=sum+a[i];
        }
        System.out.print("Sum of Array: "+sum);
    }
}