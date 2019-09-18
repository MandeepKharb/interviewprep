/*
* There are N piles of coins each containing  Ai (1<=i<=N) coins.  Now, you have to adjust the number of coins in each pile such that for any two pile, if a be the number of coins in first pile and b is the number of coins in second pile then |a-b|<=K. In order to do that you can remove coins from different piles to decrease the number of coins in those piles but you cannot increase the number of coins in a pile by adding more coins. Now, given a value of N and K, along with the sizes of the N different piles you have to tell the minimum number of coins to be removed in order to satisfy the given condition.
Note: You can also remove a pile by removing all the coins of that pile.

Input
The first line of the input contains T, the number of test cases. Then T lines follow. Each test case contains two lines. The first line of a test case contains N and K. The second line of the test case contains N integers describing the number of coins in the N piles.

Output
For each test case output a single integer containing the minimum number of coins needed to be removed in a new line.

Constraints
1<=T<=50
1<=N<=100
1<=Ai<=1000
0<=K<=1000

Example
Input
3
4 0
2 2 2 2
6 3
1 2 5 1 1 1
6 3
1 5 1 2 5 1

Output
0
1
2

Explanation
1. In the first test case, for any two piles the difference in the number of coins is <=0. So no need to remove any coins.
2. In the second test case if we remove one coin from pile containing 5 coins then for any two piles the absolute difference in the number of coins is <=3.
3. In the third test case if we remove one coin each from both the piles containing 5 coins , then for any two piles the absolute difference in the number of coins is <=3.

** For More Input/Output Examples Use 'Expected Output' option **
* */

package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfCoins {


        public static void main (String[] args)
        {
            Scanner sc;
            sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();
                int k = sc.nextInt();
                int array[] = new int[n];
                for(int i = 0; i < n; i++){
                    array[i] = sc.nextInt();
                }
                Arrays.sort(array);
                int answer=Integer.MAX_VALUE;
                int temp = 0;
                int t2 = 0;
                for(int i = 0; i < n; i++){
                    temp = t2;
                    t2 += array[i];
                    for(int j = n-1; j > i; j--){
                        if(array[j] - array[i] - k > 0){
                            temp += array[j] - array[i] - k;
                        }
                    }
                    answer = Math.min(answer,temp);
                }
                System.out.println(answer);
            }
        }

}
