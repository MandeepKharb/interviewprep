package tree.binarysearchtree;

class BSTNode {

    int data;
    Node left, right;

    BSTNode(int d) {
        data = d;
        left = right = null;
    }
}

public class RecoverBST {

    /*
     since in bst , every left node is small then root and right node is big than root.
    Due to this property if we traverse bst inorder then it will result into a sorted array.
    So to solve this traverse in inorder and find node which smaller than its previous node and then swap them.
    then tree will turn into bst.
     */



    Node previousNode;
    Node firstNode;
    Node secondNode;
    public  void findNodes(Node root ){
// this method is kind of customized inorder traversal
//first traverse left subtree, then do some processing at root and then right subtree.
        if (root ==null)
            return;
        findNodes(root.left);
        if(previousNode!=null){
            if(previousNode.data>root.data){
                if (firstNode==null){
                    firstNode=previousNode;
                }
                secondNode=root;
            }
        }
        previousNode=root;

        findNodes(root.right);
    }

    public  void recoverTree(Node root){
        findNodes(root);
// swap the firstNode and secondNode
        int val=firstNode.data;
        firstNode.data=secondNode.data;
        secondNode.data=val;
    }
}
