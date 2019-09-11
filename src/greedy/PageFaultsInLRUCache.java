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
