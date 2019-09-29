/*
* Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.

Input Format:
The input contains T, denoting number of testcases. For each testcase there will be two lines. The first line contains number of edges. The second line contains two nodes and a character separated by space. The first node denotes data value, second node denotes where it will be assigned to the previous node which will depend on character 'L' or 'R' i.e. the 2nd node will be assigned as left child to the 1st node if character is 'L' and so on. The first node of second line is root node. The struct or class Node has a data part which stores the data, pointer to left child and pointer to right child. There are multiple test cases. For each test case, the function will be called individually.

Output Format:
For each testcase, in a new line, print he maximum possible sum.

Your Task:
This is a function problem. You only need to complete the function maxPathSum that returns the maximum sum from one lead to other.

Constraints:
1 <=T <= 100
1 <= N <= 30

Example:
Input:
1
12
-15 5 L -15 6 R 5 -8 L 5 1 R -8 2 L -8 -3 R 6 3 L 6 9 R 9 0 R 0 4 L 0 -1 R -1 10 L

Output:
27

Explanation:
Testcase 1: The maximum possible sum from one leaf node to another is (3 + 6 + 9 + 0 + -1 + 10 = 27)
* */

package tree.binarytree;

public class MaxPathSumBetweenLeafNodes {

    static class Res
    {
        int res = Integer.MIN_VALUE;
    }

    public static int maxPathSumUtil(Node root, Res r){

        if (root == null)
            return 0;
        if (root.left==null && root.right == null)
            return root.data;
// slight different version of inorder traversal- call maxPathSumUtil for left tree then as per inorder traversal for the sake of processing root we don't do any thing and then we do maxPathSumUtil for right subtree

        int ls=maxPathSumUtil(root.left,r);
        int rs=maxPathSumUtil(root.right,r);

        if (root.left !=null && root.right!=null){
            r.res=Math.max(r.res,ls+rs+root.data);
            return Math.max(ls,rs)+root.data;

        }
// if node doesn't have left child
        if(root.left==null)
            return root.data+rs;
        // if any node doen't have right child.
        if (root.right==null)
            return root.data+ls;

        return r.res;

    }


}
