/*
* Given an array of integers A and a sum B, find all unique combinations in A where the sum is equal to B. The same repeated number may be chosen from A unlimited number of times.

Note:
        1. All numbers will be positive integers.
        2. Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        3. The combinations themselves must be sorted in ascending order.

Input:
First line of input contains number of testcases T. For each testcase, there will be three lines of input, first of which contains N, size of array. Next line contains N space seperated integers, and the last line contains B.

Output:
For each testcase, print the sets enclosing a backet "(" and ")". No space between two sets. If no set can be formed with the given set, then print "Empty" (without quotes).

Constraints:
1 <= T <= 500
1 <= N <= 12
1 <= A[i] <= 9
1 <= B <= 30

Example:
Input:
3
4
7 2 6 5
16
11
6 5 7 1 8 2 9 9 7 7 9
6
4
2 4 6 8
8

Output:
(2 2 2 2 2 2 2 2)(2 2 2 2 2 6)(2 2 2 5 5)(2 2 5 7)(2 2 6 6)(2 7 7)(5 5 6)
(1 1 1 1 1 1)(1 1 1 1 2)(1 1 2 2)(1 5)(2 2 2)(6)
(2, 2, 2, 2)(2, 2, 4)(2, 6)(4, 4)(8)

Explanation:
Testcase 1: Required sets with sum equal to B (8) are as follows:
[2, 2, 2, 2]
[2, 2, 4]
[2, 6]
[4, 4]
[8]
* */

package backtracking;
import java.util.*;
import java.lang.*;
import java.io.*;

public class CombinationSum {

        private static TreeSet<String> h;
        private static StringBuilder sb;

        private static void printCombinationSum(int[] a, int sumRemaining, int index)
        {
            if(sumRemaining > 0)
            {
                for(int i = index; i < a.length && sumRemaining >= a[i]; i++)
                {
                    sb.append(a[i] + " ");
                    printCombinationSum(a, sumRemaining - a[i], i);
                    sb.setLength(sb.length() - 2); // to trim the last number appended to the string
                }
            }
            else if(sumRemaining == 0)
            {
                String st = sb.toString();
                h.add(st.substring(0, st.length() - 1));
            }
        }

        public static void main (String[] args) {
            //code
            CombinationSum gfg = new CombinationSum();
            Scanner sc = new Scanner(System.in);
            int testCases, n, a[], sumRemaining;

            testCases = sc.nextInt();

            for(int i = 0; i < testCases; i++)
            {
                n = sc.nextInt();
                a = new int[n];

                for(int j = 0; j < n; j++)
                {
                    a[j] = sc.nextInt();
                }

                sumRemaining = sc.nextInt();

                h = new TreeSet<String>();
                sb = new StringBuilder();

                Arrays.sort(a);
                gfg.printCombinationSum(a, sumRemaining, 0);

                for(String s : h)
                {
                    System.out.print("(" + s + ")");
                }

                if(h.size() == 0)
                {
                    System.out.print("Empty");
                }

                System.out.println("");
            }
        }


    }

