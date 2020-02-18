package array;

/*
* **Approach***
*
* let us assume this is the given array - 5 6 7 8 9 10 1 2 3
and we need to find ----7

Idea behind this is that first we need to find the pivot element , Pivot element is the element at which order of the array changes like in above array 1 is the pivot element.
because till 1 array is ascending and at 1 array order changed as 1 <10 .

After find pivot element we can assume the array divided into two ascending sorted arrays and search the asked element.

To find pivot element-
findIndex(s,e,arr[])
find m=s+e/2
if arr[m]>arr[m+1] then m+1 is the pivot index,
else{
if(arr[s]>arr[m]) //then that means pivot element is presenet in first part of array s to m-1; so call this method recursively on this part.

findIndex(s,m-1,arr);
else
//pivot element is present in second part m+1 to e
findIndex(m+1,e,arr)


}

after finding pivot element we can call the binary search
based upon following condition -

if (searchelement >pivot element && searchelement<arr[e])

//then binary search in second half
binarysearch(pivotindex+1,e,arr[])

else
//search in first half

binarysearch(s,pivotindex-1,arr)

* */
public class SearchElementInSortedRotatedArray {

    public static int findPivot(int start,int end, int arr[]){
        int mid = (start+end)/2;
        if(arr[mid]>arr[mid+1])
            return mid+1;
        else{
            if(arr[start]>arr[mid])
                return findPivot(start,mid-1,arr);
            else
                return  findPivot(mid+1,end,arr);

        }

    }


    public static int binarySearch(int key,int start,int end,int arr[]){
        int mid = (start +end)/2;
        if (arr[mid]==key)
            return mid;
        else if (key >=arr[mid])
            return binarySearch(key,mid+1,end,arr);
        else
            return binarySearch(key,start,mid-1,arr);

    }

    public static int searchElement(){
        int arr[]={5 ,6 ,7, 8, 9, 10, 1, 2, 3};
        int key=7;
        int end= arr.length-1;
       int pivot= findPivot(0,end,arr);
        System.out.println(pivot);
        if (key >pivot  && key<arr[arr.length-1])
          return   binarySearch(key,pivot+1,arr.length-1,arr); //search in second half

else


          return   binarySearch(key,0,pivot-1,arr);//search in first half

  }

    public static void main(String[] args) {
        System.out.println(searchElement());
    }
}
