package tree.binarytree;


/*
Given a Binary Tree, convert it into its mirror.
MirrorTree1

Explanation:
Testcase1: The tree is
        1         (mirror)     1
     /      \         =>        /     \
   3       2                  2         3

Input Format:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains number of edges. The second line contains relation between nodes.
*/

public class MirrorTree {

    void mirror(BTNode node) {
        // Your code here

        if (node == null)
            return;
        else {


            mirror(node.left);  // traverse left subtree
            mirror(node.right);  // traverser right subtree

            // swap the left node with the right
            BTNode temp = node.left;
            node.left = node.right;
            node.right = temp;

        }

    }
}