/*
* Given a binary tree, return true if it is BST, else false. For example, the following tree is not BST, because 11 is in left subtree of 10. The task is to complete the function isBST() which takes one argument, root of Binary Tree.

        10
     /     \
   7       39
     \
      11

Input:
The input contains T, denoting number of testcases. For each testcase there will be two lines. The first line contains number of edges. The second line contains two nodes and a character separated by space. The first node denotes data value, second node denotes where it will be assigned to the previous node which will depend on character 'L' or 'R' i.e. the 2nd node will be assigned as left child to the 1st node if character is 'L' and so on. The first node of second line is root node. The struct or class Node has a data part which stores the data, pointer to left child and pointer to right child. There are multiple test cases. For each test case, the function will be called individually.

Output:
The function should return 1 if BST else return 0.

User Task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function isBST().

Constraints:
1 <= T <= 100
0 <= Number of edges <= 100
1 <= Data of a node <= 1000

Example:
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
0
0

Explanation:
Testcases 1: The given binary tree is not BST, hence the answer is 0.

** For More Input/Output Examples Use 'Expected Output' option **
* */

package tree.binarysearchtree;


class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class BST_Or_Not {

    Node root;


    public  int isBST(Node root) {
        if (root == null)
            return 1;  // 1 is true
        if (root.left != null && root.data < findMax(root.left).data)
            return 0; // 0 is false
        if (root.right != null && root.data > findMin(root.right).data)
            return 0; // 0 is false
        if (isBST(root.left) == 0 || isBST(root.right) == 0) {
            return 0;
        } else return 1;
    }


    Node findMin(Node root){
        if(root==null)
            return null;
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }

    Node findMax(Node root){
        if(root==null)
            return null;
        while(root.right!=null)
        {
            root=root.right;
        }
        return root;
    }

    public static void main(String args[])
    {
        BST_Or_Not tree = new BST_Or_Not();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);


            System.out.println("IS BST"+ tree.isBST(tree.root));

    }
}
