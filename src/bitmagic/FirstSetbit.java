package bitmagic;

/*Given an integer an N. The task is to print the position of first set bit found from right side in the binary representation of the number.

Input:
The first line of the input contains an integer T, denoting the number of test cases. Then T test cases follow. The only line of the each test case contains an integer N.

Output:
For each test case print in a single line an integer denoting the position of the first set bit found form right side of the binary representation of the number. If there is no set bit print "0".

Constraints:
1 <= T <= 200
0 <= N <= 106

Example:
Input:
2
18
12

Output:
2
3

Explanation:
Testcase 1: Binary representation of the 18 is 010010, the first set bit from the right side is at position 2.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstSetbit {

    public static void main(String[] args) throws IOException {
        //code
        // Using BufferedReader class to take input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int position = 0;

            while (n > 0) {
                int bit = n % 2;
                position = position + 1;
                if (bit == 1)
                    break;
                else
                    n = n / 2;


            }

            System.out.println(position);

        }
    }
}