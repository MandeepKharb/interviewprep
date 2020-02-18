/*
* Given a binary tree, count leaves in it. For example, there are two leaves in below tree

        1
     /      \
   10      39
  /
5

Input:
The task is to complete the method which takes one argument, root of Binary Tree. The struct Node has a data part which stores the data, pointer to left child and pointer to right child.
There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should return count of leaves

Constraints:
1 <=T<= 30
1 <=Number of nodes<= 100
1 <=Data of a node<= 1000

Example:
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
2
3

There are two test casess.  First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.   Second test case represents a tree with 4 edges and 5 nodes.
* */

package tree.binarytree;

public class NumberOfLeavesInBT {

    int countLeaves(BTNod node)
    {
        // Your code

        int count = 0;

        if (node == null)
            return 0 ;

        if (node.left ==null && node.right == null)
            return 1;
        count= countLeaves(node.left)+countLeaves(node.right);

        return count;

    }
}
