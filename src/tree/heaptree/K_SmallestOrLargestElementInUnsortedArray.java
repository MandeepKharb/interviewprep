package tree.heaptree;
/*
* Question: Write an efficient program for printing k largest elements in an array. Elements in array can be in any order.
For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked for the largest 3 elements i.e., k = 3 then your program should print 50, 30 and 23.
* */
public class K_SmallestOrLargestElementInUnsortedArray {

    // convert given array into MAX heap and then return the K largest or smallest elements what ever is asked
    // if it is largest then it will K elements from starting else it will be last K elements
static int arr[] ={1, 23, 12, 9, 30, 2, 50};
    public static void percolateDown(int i) {

        int l=leftChildIndex(i,arr.length);
        int r= rightChildIndex(i,arr.length);

        int max;
        if (arr[l]!= -1 && arr[l] >arr[i]){
            max=l;
        }
        else max=i;
        if(arr[r]!=-1 && arr[r]>max)
            max=r;
        if(max!=i)
        {
            // if max elememnt is not current element then swap current element with max
            int temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;
        }
        percolateDown(max);
    }

    public static int leftChildIndex(int i,int length){

        int left= 2*i+1;
        if (left>=length)
            return -1;
        else return left;
    }

    public static int rightChildIndex(int i,int length){
        int right= 2*i+2;

        if (right>=length)
            return  -1;
        else return right;
    }

    public static void pritKLargestElement(int k){
        percolateDown(0);
        for (int i = 0; i<k; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        pritKLargestElement(3);
    }
}
