/*
* Boundary Traversal of binary tree
Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. For example, boundary traversal of the following tree is “20 8 4 10 14 25 22”
* */
package tree.binarytree;

public class BoundryTraversalOfBT {

    void printBoundary(BTNod node)
    {
        // Your code here
        leftNodes(node);
        leafNodes(node);
        rightNodes(node.right);
    }

    void leftNodes(BTNod node){
        while (node.left!=null){
            System.out.print(node.data);
            node=node.left;
        }
    }
    void rightNodes(BTNod node){
        while(node.right!=null){
            System.out.print(node.data);
            node=node.right;
        }
    }

    void leafNodes(BTNod node){
        if(node!=null)
        {
            leafNodes(node.left);
            if(node.left==null && node.right==null)
                System.out.print(node.data);
            leafNodes(node.right);
        }


    }
}
