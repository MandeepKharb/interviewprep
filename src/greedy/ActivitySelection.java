/*
* Given N activities with their start and finish times. Select the maximum number of activities that can be performed by a single person,
* assuming that a person can only work on a single activity at a time.

Note : The start time and end time of two activities may coincide.

Input:
The first line contains T denoting the number of testcases. Then follows description of testcases.
First line is N number of activities then second line contains N numbers which are starting time of activies.Third line contains N finishing time of activities.

Output:
For each test case, output a single number denoting maximum activites which can be performed in new line.

Constraints:
1<=T<=50
1<=N<=1000
1<=A[i]<=100

Example:
Input:
2
6
1 3 2 5 8 5
2 4 6 7 9 9
4
1 3 2 5
2 4 3 6

Output:
4
4*/

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

class Pair {
    int x,y;
    Pair(){
        this.x=0;
        this.y=0;
    }
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}


public class ActivitySelection { static void sortPair(Pair arr[], int n) {
    Arrays.sort(arr, new Comparator<Pair>() {
        @Override public int compare(Pair p1, Pair p2) {
            return p1.x - p2.x;
        }
    });
}

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            Pair[] p = new Pair[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                p[i] = new Pair();
                p[i].y = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                p[i].x = Integer.parseInt(inputLine[i]);
            }
            sortPair(p, n);
            int i=0, j=1, ans=1;
            while(i<n && j<n){
                if(p[i].x<=p[j].y){
                    i=j;
                    j++;
                    ans++;
                } else {
                    j++;
                }
            }
            System.out.println(ans);
        }
    }
}
