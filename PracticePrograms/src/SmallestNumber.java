public class SmallestNumber {
    void smallest(int a[]){
        int min=a[0];

        for(int i=1;i<a.length;i++){
            if(a[i]<min){
                min=a[i];
            }
        }
        System.out.println("Smallest Number: "+min);
    }
}