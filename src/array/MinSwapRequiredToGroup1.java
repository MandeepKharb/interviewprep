package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinSwapRequiredToGroup1 {

    public static void main (String[] args) throws Exception {
        //code

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String str[]= br.readLine().split(" ");
            for (int i =0; i<str.length ; i++) {

                arr[i] = Integer.parseInt(str[i]);



            }

            System.out.println(numberOfSwap(arr));

        }


    }

    public static int numberOfSwap(int arr[]){
        int last = arr.length-1;
        int start =0;
        int swap=0;
        while(start<last){
            if(arr[start]==0)
                start++;
            else if (arr[last]==1)
                last--;
            else if (arr[start]==1 && arr[last]==0){
                int temp = arr[start];
                arr[start]=arr[last];
                arr[last]=temp;
                swap++;
                start++;
                last--;
            }
        }

        return swap;
    }
}
