package array;



import java.util.HashMap;
import java.util.Scanner;

/*
* "Given an array A of distinct integers. The task is to find if there are two pairs (a, b) and (c, d) such that a+b = c+d, and elements of array are distinct.
Singple line output, print the 1 if pair exsits else 0."

* */
public class EqualSumOfTwoPairs {

    private static void pairExists(int arr[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i] + arr[j];
                if (map.containsKey(temp)) {
                    flag = 1;
                    break;
                } else {

                    map.put(temp, 1);
                }
            }
        }

        System.out.println(flag);

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

            pairExists(arr);
        }

    }
    }

