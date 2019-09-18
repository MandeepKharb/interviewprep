/*Given three increasingly sorted arrays A, B, C of sizes N1, N2, and N3 respectively, you need to print all common elements in these arrays.

Note: Please avoid printing the same common element more than once.

Input:
First line contains a single integer T denoting the total number of test cases. T testcases follow. Each testcase contains four lines of input. First line consists of 3 integers N1, N2 and N3, denoting the sizes of arrays A, B, C respectively. The second line contains N1 elements of A array. The third lines contains N2 elements of B array. The fourth lines contains N3 elements of C array.

Output:
For each testcase, print the common elements of array. If not possible then print -1.

Constraints:
1 <= T <= 100
1 <= N1, N2, N3 <= 107
1 <= Ai, Bi, Ci <= 1018

Example:
Input:
1
6 5 8
1 5 10 20 40 80
6 7 20 80 100
3 4 15 20 30 70 80 120
Output:
20 80

Explanation:
Testcase1:  20 and 80 are the only common elements*/
package hashing;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CommonElements {

    /*package whatever //do not write package name here */


        public static void main (String[] args) throws IOException {
            //code
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t= Integer.parseInt(br.readLine());
            while(t-->0){
                String s[]= br.readLine().split(" ");

                int n1 = Integer.parseInt(s[0]);
                int n2 = Integer.parseInt(s[1]);
                int n3 = Integer.parseInt(s[2]);
                String s1[]= br.readLine().split(" ");
                String s2[]= br.readLine().split(" ");
                String s3[]= br.readLine().split(" ");
                int arr1[] = new int[n1];
                int arr2[] = new int [n2];
                int arr3[] = new int [n3];
                HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
                HashSet<Integer> hs1 = new HashSet <Integer>();
                HashSet<Integer> hs2 = new HashSet <Integer>();
                HashSet<Integer> hs3 = new HashSet <Integer>();

                for (int i =0; i<n1 ; i++) {

                    arr1[i] = Integer.parseInt(s1[i]);
                    hs1.add(arr1[i]);

                }
                Iterator itr = hs1.iterator();
                while (itr.hasNext()){
                    Integer value=(Integer) itr.next();
                    if (hm.containsKey( value )){
                        hm.put( value, hm.get( value)+1);

                    }

                    else hm.put(value,1);
                }

                for (int i =0; i<n2 ; i++) {

                    arr2[i] = Integer.parseInt(s2[i]);
                    hs2.add(arr2[i]);
                }
                Iterator itr1 = hs2.iterator();
                while (itr1.hasNext()){
                    Integer value=(Integer) itr1.next();
                    if (hm.containsKey( value )){
                        hm.put( value, hm.get( value)+1);

                    }

                    else hm.put(value,1);
                }
                for (int i =0; i<n3 ; i++) {


                    arr3[i] = Integer.parseInt(s3[i]);
                    hs3.add(arr3[i]);
                }
                Iterator itr2 = hs2.iterator();
                while (itr2.hasNext()){
                    Integer value=(Integer) itr2.next();
                    if (hm.containsKey( value )){
                        hm.put( value, hm.get( value)+1);

                    }

                    else hm.put(value,1);
                }

                for (Map.Entry<Integer,Integer> entry : hm.entrySet())
                    if (entry.getValue()==3)
                        System.out.print(entry.getKey() + " ");

            }
        }
    }

