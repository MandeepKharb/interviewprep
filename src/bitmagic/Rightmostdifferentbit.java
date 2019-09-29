/*
* Given two numbers M and N. The task is to find the position of rightmost different bit in binary representation of numbers.

Input:
The input line contains T, denoting the number of testcases. Each testcase follows. First line of each testcase contains two space separated integers M and N.

Output:
For each testcase in new line, print the position of rightmost different bit in binary representation of numbers. If both M and N are same then print -1 in this case.

Constraints:
1 <= T <= 100
1 <= M <= 103
1 <= N <= 103

Example:
Input:
2
11 9
52 4

Output:
2
5

Explanation:
Tescase 1: Binary representaion of the given numbers are: 1011 and 1001, 2nd bit from right is different.*/
package bitmagic;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Rightmostdifferentbit {

    public static void main (String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int k=0;k<t;k++)
        {
            int n=in.nextInt();
            int m=in.nextInt();
            int temp=n^m; // binary rep of 11 is = 1011 and binary rep of 9  is =1001 XOR of these integer would be
            /*
            * Num1 : 1011   11
              Num2 : 1001   9
            ======================
            XOR  :   0010  and integer rep of this is =2
            * */
            int count=1;

            if(temp==0)
            {
                System.out.println(-1);
            }
            else
            {
                while(temp>0)
                {
                    if((temp&1)==1)
                    {
                        System.out.println(count);
                        break;
                    }
                    count++;
                    temp=temp>>1; // this is signed right shift operator in java
                    //When shifting right with an arithmetic right shift, the least-significant bit is lost and the most-significant bit is copied.
                    //most right is LeastSignificantBit --lsb
                    //Most left is MostSignificantBit--msb

                    //bitwise left shift--When shifting left, the most-significant bit is lost, and a 00 bit is inserted on the other end.   0010 << 1  →  0100 , in other words A single left shift multiplies a binary number by 2:

                    //Bitwise right shift --When shifting right with a logical right shift, the least-significant bit is lost and a 00 is inserted on the other end.    1011 >>> 1  →  0101 in other words - For positive numbers, a single logical right shift divides a number by 2, throwing out any remainders.

                }
            }
        }
    }
}
