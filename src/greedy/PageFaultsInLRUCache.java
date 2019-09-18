/*
* In operating systems that use paging for memory management, page replacement algorithm are needed to decide which page needs to be replaced when the new page comes in. Whenever a new page is referred and is not present in memory, the page fault occurs and Operating System replaces one of the existing pages with a newly needed page. Given a sequence of pages and memory capacity, your task is to find the number of page faults using Least Recently Used (LRU) Algorithm.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains n number of pages and next line contains space seaprated sequence of pages. The following line consist of the capacity of the memory.
Note: Pages are referred in the order left to right from the array (i.e index 0 page is referred first then index 1 and so on). Memory is empty at the start.

Output:
Output the number of page faults.

Constraints:
1<=T<=100
1<=n<=1000
4<=capacity<=100

Example:
Input:
2
9
5 0 1 3 2 4 1 0 5
4
8
3 1 0 2 5 4 1 2
4

Output:
8
7

Explanation:
Testcase 1:
memory allocated with 4 pages 5, 0, 1, 3: page fault = 4
page number 2 is required, replaces LRU 5: page fault = 4+1 = 5
page number 4 is required, replaces LRU 0: page fault = 5 + 1 = 6
page number 1 is required which is already present: page fault = 6 + 0 = 6
page number 0 is required which replaces LRU 1: page fault = 6 + 1 = 7
page number 5 is required which replaces LRU 3: page fault = 7 + 1  =8.
* */
package greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class PageFaultsInLRUCache {

    public static void main (String[] args)
    {
        //code
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();//size of array
            int a[]=new int[n];
            //scanning the page
            for(int i=0;i<n;i++) { a[i]=sc.nextInt();}
            int capacity=sc.nextInt();
            //working as queue
            ArrayList<Integer> cache=new ArrayList<>();
            int count=0;
            for(int i=0;i<n;i++){
                //if empty adding to the list and increase the count
                if(cache.size()<capacity){
                    if(!cache.contains(a[i])){
                        cache.add(a[i]);
                        count++;
                    }else{
                        //if already in list updating the list
                        //removing and addint to the head of list
                        int index=cache.indexOf(a[i]);
                        cache.remove(index);
                        cache.add(a[i]);
                    }
                }else{
                    //if contain in the list the update the
                    //list by removing from the index and add to
                    //the front of the list
                    if(cache.contains(a[i])){
                        int index1=cache.indexOf(a[i]);
                        cache.remove(index1);
                        cache.add(a[i]);
                    }else{
                        //if not contain in list remove from the
                        //zreo index and add the current page to
                        //to the head of the list and increase the count
                        cache.remove(0);
                        cache.add(a[i]);
                        count++;
                    }
                }

            }
            System.out.println("Number of page faults : "+count);
        }
    }
}
