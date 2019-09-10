/*
* Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.

Input:
The first line of input contains an integer N denoting the number of elements in the stream. Then the next N lines contains integer x denoting the number to be inserted into the stream.
Output:
For each element added to the stream print the floor of the new median in a new line.

Constraints:
1 <= N <= 106
1 <= x <= 106

Example:
Input:
4
5
15
1
3
Output:
5
10
5
4

Explanation:
Testcase 1:
Flow in stream : 5, 15, 1, 3
5 goes to stream --> median 5 (5)
15 goes to stream --> median 10 (5, 15)
1 goes to stream --> median 5 (5, 15, 1)
3 goes to stream --> median 4 (5, 15, 1, 3)
* */
package tree.heaptree;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianInARunningStream {

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        // we have taken priority queue Collections.reverseOrder() method will reverse the natural ordering of integers in priority queue which is
        // ascending. Collections.reverseOrder() will make it descendig i.e biggest element at start of queue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n=sc.nextInt();
        while(n-->0){
            int x=sc.nextInt();
            if(maxHeap.isEmpty()){
                maxHeap.add(x);
            }else{
                if(x<=maxHeap.peek()){
                    maxHeap.add(x);
                    if(maxHeap.size()-minHeap.size()==2){
                        minHeap.add(maxHeap.remove());
                    }
                }else{
                    minHeap.add(x);
                    if(minHeap.size()-maxHeap.size()==2){
                        maxHeap.add(minHeap.remove());
                    }
                }
            }
            if(maxHeap.size()>minHeap.size()){
                System.out.println(maxHeap.peek());
            }else if(minHeap.size()>maxHeap.size()){
                System.out.println(minHeap.peek());
            }else{
                int ans=(maxHeap.peek()+minHeap.peek())/2;
                System.out.println(ans);
            }
        }
    }
    
}
