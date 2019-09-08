package graph;

/*
This problem is example of Dijkstra Algorithm

*Given a square grid of size N, each cell of which contains integer cost which represents a cost to traverse through that cell, we need to find a path from top left cell to bottom right cell by which total cost incurred is minimum.

Note : It is assumed that negative cost cycles do not exist in input matrix.

Input:
The first line of input will contain number of testcases T. Then T test cases follow. Each test case contains 2 lines. The first line of each test case contains an integer N denoting the size of the grid. Next line of each test contains a single line containing N*N space separated integers depicting the cost of respective cell from (0,0) to (N,N).

Output:
For each test case output a single integer depecting the minimum cost to reach the destination.

Constraints:
1 <= T <= 50
1 <= N <= 50

Example:
Input:
2
5
31 100 65 12 18 10 13 47 157 6 100 113 174 11 33 88 124 41 20 140 99 32 111 41 20
2
42 93 7 14

Output:
327
63
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x=x;
        this.y =y;

    }
}
public class MinimumCostPath {

    /*this method is slight different version of Dijkstra's Algo*/

    static int dx[] = {0,0,1,-1};
    static int dy[]={1,-1,0,0};

    private static int pathWithMinCost(int arr[][], int distance[][], int size){
        distance[0][0] = arr[0][0];
        
        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(0,0));
        int len =1;
        while(!dq.isEmpty()){
            for(int i=0;i<len;i++){
                Pair temp = dq.removeFirst();
                for(int j=0;j<4;j++){
                    int a=temp.x+dx[j];
                    int b=temp.y+dy[j];
                    if(validIndex(a,b,size)){

                        if(distance[temp.x][temp.y]+arr[a][b]<distance[a][b]){
                            distance[a][b]=distance[temp.x][temp.y]+arr[a][b];
                            dq.addLast(new Pair(a,b));
                        }
                    }

                }
            }
            len = dq.size();
        }
        return distance[size-1][size-1];

    }

    private static boolean validIndex(int a,int b, int size){
        return(a>=0&&b>=0&&a<size&&b<size);
    }

    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            int size = Integer.parseInt(br.readLine());
            // this 2d array contains the adjancy matrix which is input in this case
            int arr[][] = new int[size][size];
            // this 2d array of distance represnts distance of each node from each node
            int distance[][] = new int[size][size];
            String s[] = br.readLine().split(" ");
            int count=0;
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    arr[i][j]=Integer.parseInt(s[count]);
                    count++;
                    distance[i][j]=Integer.MAX_VALUE;
                }
            }
            System.out.println(pathWithMinCost(arr,distance,size));
        }
    }
}


