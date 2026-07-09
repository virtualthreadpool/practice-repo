public class PrimeArray {
    void Primerange(int n){
        int[] a=new int[n];
        int k=0;

        for(int i=2;i<=n;i++){
            int count=0;
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count==2){
                a[k]=i;
                k++;
            }
        }
        for(int i=0;i<k;i++){
            System.out.print(a[i]+" ");
        }
    }
}