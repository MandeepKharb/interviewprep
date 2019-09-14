package hashing;

import java.util.HashMap;

public class LargestSubArrayWithSumZero {

    /*
    * Given an array having both positive an negative integers. The task is to complete the function maxLen() which returns the length of maximum subarray with 0 sum. The function takes two arguments an array A and n where n is the size of the array A.

Input:
The first line of input contains an element T denoting the number of test cases. Then T test cases follow. Each test case consist of 2 lines. The first line of each test case contains a number denoting the size of the array A. Then in the next line are space separated values of the array A.

Output:
For each test case output will be the length of the largest subarray which has sum 0.

User Task:
Sinec this is a functional problem you don't have to worry about input, you just have to complete the function maxLen().

Constraints:
1 <= T <= 100
1 <= N <= 100
-1000 <= A[] <= 1000

Example:
Input
1
8
15 -2 2 -8 1 7 10 23

Output
5
    * */

    int maxLen(int arr[], int n)
    {

        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0;      // Initialize sum of elements
        int max_len = 0;  // Initialize result

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            // Add current element to sum
            sum += arr[i];

            if (arr[i] == 0 && max_len == 0)
                max_len = 1;

            if (sum == 0)
                max_len = i+1;

            // Look this sum in hash table
            Integer prev_i = hM.get(sum);

            // If this sum is seen before, then update max_len
            // if required
            if (prev_i != null)
                max_len = Math.max(max_len, i-prev_i);
            else  // Else put this sum in hash table
                hM.put(sum, i);
        }

        return max_len;
    }
}
