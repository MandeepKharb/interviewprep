/*

Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.

* */

package array;

public class Sort012 {

    public static void main(String args[]) {

        int arr[] = {};
        int low = 0, mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {

            if (arr[mid] == 0) {
                swap(arr[low], arr[mid]);
                low++;
                mid++;
                continue;
            }
            if (arr[mid] == 1) {
                mid++;
                continue;
            }
            if (arr[mid] == 2) {
                swap(arr[mid], arr[high]);
                high--;
                continue;
            }

        }
    }
    public static void swap (int a, int b){
        int temp;
        temp=a;
        a=b;
        b=temp;
    }

}