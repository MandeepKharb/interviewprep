package array;

import java.util.Arrays;
import java.util.Collections;

public class PrimeInAscCompositeInDesc {

   static  int arr[] = { 5, 4, 3, 7, 8, 10,2};
    static int primeIndex=0;
    static int nonPrimeIndex=arr.length-1;

    public static boolean isPrime(int n){
        boolean isPrime=true;
        if (n <=1)
            return false;
        else{
            for (int i=2; i<n; i++){
                if (n%i==0)
                    isPrime=false;
            }
        }

        return isPrime;
    }



    public static void rearrange(){

        while (primeIndex < nonPrimeIndex){

            if (isPrime(arr[primeIndex]) && !isPrime(arr[nonPrimeIndex])){
                primeIndex++;
                nonPrimeIndex--;
            }
            else if (isPrime(arr[primeIndex]) && isPrime(arr[nonPrimeIndex]))
            {
                primeIndex++;
            }

            else if (!isPrime(arr[primeIndex]) && isPrime(arr[nonPrimeIndex]))
            {
                int temp= arr[primeIndex];
                arr[primeIndex]=arr[nonPrimeIndex];
                arr[nonPrimeIndex]=temp;

                primeIndex++;
                nonPrimeIndex--;

            }

            else{
                nonPrimeIndex--;
            }

        }



    }


    public static void main(String[] args) {
        rearrange();
        Arrays.sort(arr, 0, primeIndex+1);
        Arrays.sort(arr,primeIndex+1,arr.length-1); // here we have sorted in ascending order but we need to sort the array in descending order from primeIndex+1 till n-1
        // convert the subarray from primeindex+1 till n-1 into descneding by making simple swaps like below
        int start = primeIndex+1;
        int last = arr.length-1;
        while(start < last){
           int temp = arr[start];
           arr[start]=arr[last];
           arr[last] = temp;
           start++;
           last --;

        }

        System.out.println("prime index " + primeIndex + "Non prime index " +nonPrimeIndex);
        for (int i : arr) {
            System.out.println(i + " ");

        }
    }



}
