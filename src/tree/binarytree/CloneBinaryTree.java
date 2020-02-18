/*
* Given a Binary Tree having random pointers clone the Binary Tree.
* The task is to complete the function cloneTree which take one argument the root of the tree to be copied and should return the root of the cloned tree.

Input:
The first line of input contains the no of test cases.
Then T test cases follow. Each test case contains 2 lines the first line contains and integer N denoting the no of edges of the tree and then in the next line are N space separated queries .
The query on tree are of three types
a) a b L  (Represents that b is the left child of a)
b) a b R (Represents that b is the right child of a)
c) a b X (Represents a random pointer from node a to node b)

Output:
Your function should return the root of the cloned tree. The output will be 1 if the tree is successfully cloned.

Constraints:
1 <=T<= 30
1 <=Number of nodes<= 100
1 <=Data of a node<= 1000

Example(To be used only for expected output):
Input
1
6
6 3 L 6 8 R 3 1 L 3 5 R 1 3 X 5 6 X

Output
1

* */
package tree.binarytree;

import java.util.HashMap;
import java.util.Map;

class BT_Tree {
    int data;
    BT_Tree left,right,random;
    BT_Tree(int d){
        data=d;
        left=null;
        right=null;
        random=null;
    }
}
public class CloneBinaryTree {
    public static void cloneRandom(BT_Tree tree, BT_Tree clone, Map<BT_Tree, BT_Tree> m){
        if(tree == null)
            return ;
        clone.random = m.get(tree).random;
        cloneRandom(tree.left,clone.left,m);
        cloneRandom(tree.right,clone.right,m);
    }

    public static BT_Tree cloneLeftRight(BT_Tree root, Map<BT_Tree, BT_Tree> m){
        if(root == null)
            return null;
        // put all the nodes in hashmap key will be the given tree node and value will be the cloned node for that node
        m.put(root,new BT_Tree(root.data));

        m.get(root).left = cloneLeftRight(root.left,m); //get the left child of given tree and create a new node in above line and assign it to the left of new tree
        m.get(root).right = cloneLeftRight(root.right,m); // same for right child

        return m.get(root);
    }

    public static BT_Tree cloneTreee(BT_Tree tree){
        if(tree == null)
            return null;
        Map<BT_Tree, BT_Tree> m = new HashMap<BT_Tree, BT_Tree>();
        BT_Tree cloneTree = cloneLeftRight(tree,m);
        cloneRandom(tree,cloneTree,m);
        return cloneTree;
    }

    public static BT_Tree cloneTree(BT_Tree tree){
        return cloneTreee(tree);
    }
}
