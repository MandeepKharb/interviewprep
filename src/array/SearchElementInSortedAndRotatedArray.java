package array;

public class SearchElementInSortedAndRotatedArray {

    public static int search(int arr[], int l, int h, int key){
        if (l>h)
            return -1;
        int mid = l+h/2;

        if (key==arr[mid])
            return mid;

        /* Check If arr[l...mid] first subarray is sorted */
        if (arr[l]<arr[mid]){

            if (key>arr[l] && key < arr[mid])
            return      search(arr,l,mid,key);

            return search(arr,mid+1,h,key);


        }
          /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid+1, h, key);

        return search(arr, l, mid-1, key);
    }
}
