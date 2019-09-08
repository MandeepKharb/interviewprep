package DynamicProg;

/*
* You are given a number N. You have to find the number of operations required to reach N from 0. You have 2 operations available:

Double the number
Add one to the number
Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer N.

Output:
For each test case, in a new line, print the minimum number of operations required to reach N from 0.

Constraints:
1<=T<=100
1<=N<=104

Example:
Input:
2
8
7
Input:
4
5

Explanation:
Testcase1:
Input  : N = 8
Output : 4
0 + 1 = 1, 1 + 1 = 2, 2 * 2 = 4, 4 * 2 = 8
Testcase2:
Input  : N = 7
Output : 5
0 + 1 = 1, 1 + 1 = 2, 1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinOpReqdForNToZero {
    public static void main (String[] args) throws IOException {
        //code

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // n : size of array
            int n = Integer.parseInt(br.readLine());
            minOp(n);

        }


    }
    public static void minOp(int n){
        int count =0;
        while(n >0){

            if(n % 2 !=0){
                n = n-1;

            }
            else {
                n = n/2;

            }
            count ++;
        }

        System.out.println(count);
    }
}
