package tree.binarysearchtree;

public class BST_Or_Not {

    public  int isBST(BSTNode root) {
        if (root == null)
            return 1;
        if (root.left != null && root.data < findMax(root.left).data)
            return 0;
        if (root.right != null && root.data > findMin(root.right).data)
            return 0;
        if (isBST(root.left) == 0 || isBST(root.right) == 0) {
            return 0;
        } else return 1;
    }

    BSTNode findMin(BSTNode root){
        if(root==null)
            return null;
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }

    BSTNode findMax(BSTNode root){
        if(root==null)
            return null;
        while(root.right!=null)
        {
            root=root.right;
        }
        return root;
    }
}
