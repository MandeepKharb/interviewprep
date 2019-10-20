/*
* The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other. Given an integer n, print all distinct solutions to the n-queens puzzle.
* Each solution contains distinct board configurations of the n-queens’ placement, where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes
* that the ith-column queen is placed in the row with that number. For eg below figure represents a chessboard [3 1 4 2].


Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the chessboard.

Output:
For each test case, output your solutions on one line where each solution is enclosed in square brackets '[', ']' separated by a space .
The solutions are permutations of {1, 2, 3 …, n} in increasing order where the number in the ith place denotes the ith-column queen is placed in the row with that number, if no solution exists print -1.

Constraints:
1 <= T <= 10
1 <= n <= 10

Example:
Input
2
1
4
Output:
[1 ]
[2 4 1 3 ] [3 1 4 2 ]

** For More Input/Output Examples Use 'Expected Output' option **
* */
package backtracking;

import java.util.Scanner;

public class NQueens {

    public static void main (String[] args)
    {

        Scanner obj= new Scanner(System.in);

        int tc= obj.nextInt();

        while(tc-->0)
        {
            int n= obj.nextInt();

            if(n==2 || n==3)
            {
                System.out.println("-1");
                continue;
            }


            int output[][]= new int[n][n];

            helper(output, n, 0);

            System.out.println();



        }

    }

    public static void helper(int output[][], int n, int rowIndex)
    {
        if(rowIndex>=n)
        {
            System.out.print("[");

            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    if(output[i][j]==1)
                        System.out.print((j+1)+" ");
                }
            }

            System.out.print("] ");

            return;

        }


        for(int i=0; i<n; i++)
        {
            if(isSafe(output, rowIndex, i, n))
            {
// if that postion is safe place queen (1)
                output[rowIndex][i]= 1;
// recur this function on next rows
                helper(output, n, rowIndex+1);
// backtrack by placing 0 , if conditions is not satisfied
                output[rowIndex][i]= 0;
            }
        }

        return;
    }

    public static boolean isSafe( int output[][], int row, int col, int n )
    {
        // check if there exists 1 in that row
        for(int i=0; i<row; i++)
            if( output[i][col] == 1 )
                return false;
        // check if there exists 1 (queen) on diagnoally upper left of current position
        for( int i= row, j= col; i>=0 && j>=0; i--, j-- )
            if( output[i][j] == 1 )
                return false;
        // check if there exists 1 (queen) on diagonally right downside of current postion
        for(int i=row, j=col; i>=0 && j<n; i--, j++ )
            if( output[i][j] == 1 )
                return false;

        return true;

    }

}
