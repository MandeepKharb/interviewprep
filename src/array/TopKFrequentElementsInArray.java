package array;

import java.util.*;

public class TopKFrequentElementsInArray {

        public static List<Integer> topKFrequent(int[] nums, int k) {
            // build hash map : character and how often it appears
            HashMap<Integer, Integer> count = new HashMap();
            for (int n: nums) {
                count.put(n, count.getOrDefault(n, 0) + 1);
            }

            // init heap 'the less frequent element first'
            PriorityQueue<Integer> heap =
                    new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));  // this is lambda expression implementaion of comparator
            //This is the Comparator the Priority Queue will use. It will look at the values of the keys and sort them in ascending order.

            // keep k top frequent elements in the heap
            for (int n: count.keySet()) {
                heap.add(n);
                if (heap.size() > k)
                    heap.poll();
            }

            // build output list
            List<Integer> top_k = new LinkedList();
            while (!heap.isEmpty())
                top_k.add(heap.poll());
            Collections.reverse(top_k);
            return top_k;
        }

    public static void main(String[] args) {

            int nums[]={1,1,1,2,2,3};
        System.out.println(topKFrequent(nums,2));
    }

}
