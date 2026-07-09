public class LargestNumber {
    void largest(int a[]){
        int max=a[0];

        for(int i=1;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        System.out.println("Largest Number: "+max);
    }
}