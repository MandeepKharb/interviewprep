/*
* Given a 2D screen, location of a pixel in the screen ie(x,y) and a color(K), your task is to replace color of the given pixel and all adjacent(excluding diagonally adjacent) same colored pixels with the given color K.

Example:

{{1, 1, 1, 1, 1, 1, 1, 1},
{1, 1, 1, 1, 1, 1, 0, 0},
{1, 0, 0, 1, 1, 0, 1, 1},
{1, 2, 2, 2, 2, 0, 1, 0},
{1, 1, 1, 2, 2, 0, 1, 0},
{1, 1, 1, 2, 2, 2, 2, 0},
{1, 1, 1, 1, 1, 2, 1, 1},
{1, 1, 1, 1, 1, 2, 2, 1},
 };

 x=4, y=4, color=3

{{1, 1, 1, 1, 1, 1, 1, 1},
{1, 1, 1, 1, 1, 1, 0, 0},
{1, 0, 0, 1, 1, 0, 1, 1},
{1, 3, 3, 3, 3, 0, 1, 0},
{1, 1, 1, 3, 3, 0, 1, 0},
{1, 1, 1, 3, 3, 3, 3, 0},
{1, 1, 1, 1, 1, 3, 1, 1},
{1, 1, 1, 1, 1, 3, 3, 1}, };

Note: Use zero based indexing.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The first line of each test case contains Two integers N and M denoting the size of the matrix. Then in the next line are N*M space separated values of the matrix. Then in the next line are three values x, y and K.

Output:
For each test case print the space separated values of the new matrix.

Constraints:
1 <= T <= 100
1 <= M[][] <= 100

Example:
Input:
3
3 4
0 1 1 0 1 1 1 1 0 1 2 3
0 1 5
2 2
1 1 1 1
0 1 8
4 4
1 2 3 4 1 2 3 4 1 2 3 4 1 3 2 4
0 2 9

Output:
0 5 5 0 5 5 5 5 0 5 2 3
8 8 8 8
1 2 9 4 1 2 9 4 1 2 9 4 1 3 2 4
* */
package recursion;

import java.lang.*;
import java.io.*;

class FloodFill {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int not = Integer.parseInt(br.readLine());
		
		while(not-- > 0) {
		    String str[] = br.readLine().split(" ");
		    
		    int m = Integer.parseInt(str[0]);
		    int n = Integer.parseInt(str[1]);
		    
		    String matString[] = br.readLine().split(" ");
		    
		    int mat[][] = new int[m][n];
		    
		    int k=0;
		    for(int i=0; i<m; i++) {
    		    for(int j=0; j<n; j++, k++)
    		        mat[i][j] = Integer.parseInt(matString[k]);
		    }
		    
		    String query[] = br.readLine().split(" ");
		    int x = Integer.parseInt(query[0]);
		    int y = Integer.parseInt(query[1]);
		    int color = Integer.parseInt(query[2]);
		    
		    int key = mat[x][y];
		    floodMat(mat, m, n, x, y, color, key);
		    
		    for(int i=0; i<m; i++) {
		        for(int j=0; j<n; j++) 
		            System.out.print(mat[i][j] + " ");
		    }
		    
		    System.out.println();
		}
	}
	
	public static void floodMat(int mat[][], int m, int n, int x, int y, int color, int key) {
	    if(mat[x][y] == key) {
	        
	        mat[x][y] = color;
	        
	        if(x > 0)
	            floodMat(mat, m, n, x-1, y, color, key);
	        if(x < m-1)
	            floodMat(mat, m, n, x+1, y, color, key);
	        if(y > 0)
	            floodMat(mat, m, n, x, y-1, color, key);
	        if(y < n-1)
	            floodMat(mat, m, n, x, y+1, color, key);
	            
	    }
	    
	}
	
}