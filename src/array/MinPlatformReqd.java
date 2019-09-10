package array;

/*
* Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.
 */

import java.util.Arrays;
import java.util.Scanner;

public class MinPlatformReqd {


    public static int findPlatform(int arr[], int dep[], int n ){
        int platformRequired=1;
        int result = platformRequired;

        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1;
        int j=0;

        while(i<n && j< n){

            if (arr[i]<dep[j]){
                platformRequired++;
                i++;
                if(platformRequired>result)
                    result=platformRequired;

            }

            else {
                platformRequired--;
                j++;
            }
        }

        return result;
    }


    public static void main (String[] args) {
        //code

        Scanner scanner=new Scanner(System.in);
        int tc= scanner.nextInt();
        while(tc-->0)
        {
            int n=scanner.nextInt();
            int arr[] = new int[n];
            int dep[] =new int[n];
            int i=0;
            while(i<n)       {
                arr[i]=scanner.nextInt();
                dep[i]=scanner.nextInt();
                i++;

            }

            System.out.println(findPlatform(arr, dep, n));
        }

    }


}
