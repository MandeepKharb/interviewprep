package tree.binarytree;

/*
* Search two nodes in binary tree
* if (node found)
* return node;
* else return null;
* when some node receives values from both left and right then that node is the LCA of given nodes
* */

public class LowestCommonAncestor {

    public static BTNode LCA(BTNode root, BTNode firstNode, BTNode secondNode){
        if(root == null)
            return null;
        if (root.data ==firstNode.data || root.data==secondNode.data )
            return root;
        // inorder traversal leftnode -> do processing at curent node -> right node

    BTNode leftLCA=LCA(root.left,firstNode,secondNode);
    BTNode rightLCA=LCA(root.right,firstNode,secondNode);
    if (leftLCA !=null && rightLCA !=null)
        return root;

        // Otherwise check if left subtree or right subtree is LCA
        return (leftLCA != null) ? leftLCA : rightLCA;

    }
}
