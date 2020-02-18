/*
* Given an array of integers where each element represents the max number of steps that can be made forward from that element. The task is to find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

Input:
The first line contains an integer T, depicting total number of test cases.  Then following T lines contains a number n denoting the size of the array. Next line contains the sequence of integers a1, a2, ..., an.

Output:
For each testcase, in a new line, print the minimum number of jumps. If answer is not possible print "-1"(without quotes).

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
0 <= ai <= 107

Example:
Input:
2
11
1 3 5 8 9 2 6 7 6 8 9
6
1 4 3 2 6 7
Output:
3
2

Explanation:
Testcase 1: First jump from 1st element, and we jump to 2nd element with value 3. Now, from here we jump to 5h element with value 9. and from here we will jump to last.
*
* */

package dynamicprog;


public class MinimumJumpsReqdToReachEndOfArry {
    public static  int jumpsReqd(int arr[]){

        if (arr.length<=1)
            return 0;

        int ladder=arr[0]; //keep track of largest ladder you have
        int stairs=arr[0]; //keep track of stairs in current ladder
        int jump=1;



        for(int level=1; level<arr.length; level++){

            if (level==arr.length-1)
            return  jump;
            if (arr[level]+level > ladder)
                ladder = arr[level]+level;
            stairs--;
            if (stairs==0) {
                jump++;
                stairs = ladder - level;
            }

        }

        return jump;


    }

    public static void main(String[] args) {

        int arr[]={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(jumpsReqd(arr));
    }
}
