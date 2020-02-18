package bitmagic;

/*
* Hamming distance between two Integers
Given two integers, the task is to find the hamming distance between two integers.
Hamming Distance between two integers is the number of bits which are different at same position in both numbers.

Examples:

Input: n1 = 9, n2 = 14
Output: 3
9 = 1001, 14 = 1110
No. of Different bits = 3

Input: n1 = 4, n2 = 8
Output: 2


Approach is -

Calculate the XOR of two numbers.
Count the number of set bits.
* */

public class HammingDistance {

    static int hammingDistance(int n1, int n2)
    {
        int x = n1 ^ n2;
        int setBits = 0;

        while (x > 0)
        {
          //  System.out.println(x&1);
            setBits = setBits + (x & 1);   // bitwise & operator
            x =x>>1;     // >> right shift operator
                            // here we are right shifting by 1
            // thumb rule about shift operators is -- right shift (>>) by n bits = dividing the integer by 2 to the power n
            // left shift (<<) by n bits is == multiplying the given integer by 2 to the power n
        }

        return setBits;
    }

    // Driver code
    public static void main(String[] args)
    {
        int n1 = 9, n2 = 14;
        System.out.println(hammingDistance(n1, n2));
    }
}
