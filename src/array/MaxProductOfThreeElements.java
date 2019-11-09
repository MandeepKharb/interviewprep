package array;

/*
* Given an integer array, find and print three element in the array whose product is maximum. Array can contain -ve values as well

 * */

import java.util.Scanner;

public class MaxProductOfThreeElements {

    private static void maxProduct(int arr[]){
        // for +ve values
        long  first=Integer.MIN_VALUE, second=Integer.MIN_VALUE, third=Integer.MIN_VALUE;
        long result =0;

        // for -ve values
        long  Nfirst=Integer.MAX_VALUE, Nsecond=Integer.MAX_VALUE, Nthird=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>first)
            {
                third=second;
                second=first;
                first=arr[i];
            }
            else if(arr[i]>second)
            {
                third=second;
                second=arr[i];
            }
            else if(arr[i]>third)
            {
                third = arr[i];
            }
            //negatives
            if(arr[i]<Nthird)
            {
                Nfirst=Nsecond;
                Nsecond=Nthird;
                Nthird=arr[i];
            }
            else if(arr[i]<Nsecond)
            {
                Nfirst=Nsecond;
                Nsecond=arr[i];
            }
            else if(arr[i]<Nfirst)
            {
                Nfirst = arr[i];
            }
        }



        System.out.println("Positive values are: " + first +" " +second +" "+ " "+ third);
        System.out.println("Negative values are: " + Nfirst +" " +Nsecond +" "+ " "+ Nthird);

        result=first*second*third;

        if( result<first*Nsecond*Nthird)
        {
            result=first*Nsecond*Nthird;
        }

        System.out.println("Max Product is :" + result);
    }
    public static void main (String args[]){

        Scanner scanner=new Scanner(System.in);
        int tc= scanner.nextInt();
        while(tc-->0)
        {
            int n=scanner.nextInt();
            int arr[] = new int[n];

            int i=0;
            while(i<n)       {
                arr[i]=scanner.nextInt();

                i++;

            }

            maxProduct(arr);
        }

    }
}
