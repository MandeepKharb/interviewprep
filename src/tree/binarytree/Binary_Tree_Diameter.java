package tree.binarytree;

/*
* Given a binary tree you need to find the diameter of binary tree
*
* Diameter of binary tree is the longest path between two leaf nodes.
* it may and may not pass through the root.
* if diameter passes through the root node then it will be = height of left subtree+height of right subtree +1 (root)
*
* if diameter doen't pass through the root then we will calculate the diameter of left subtree and diameter of right subtree and will take max of these values
*
* */

import java.lang.*;

// A Binary Tree node
class Node
{
    int data;
    BTNod left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}


/*This is a function problem.You only need to complete the function given below*/
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class Tree {
    /* Complete the function to get diameter of a binary tree */
    int diameter(BTNod node) {
        if (node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int leftDiameter = diameter(node.left);
        int rightDiameter = diameter(node.right);

        int diameter = Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));

        return diameter;


    }

    int height(BTNod node) {
        if (node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);

    }

}