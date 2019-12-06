package tree.binarytree;

public class BT2DLL {

    BTNode head;
    static BTNode prev = null;
    BTNode BToDLL(BTNode root)
    {
        // inorder traversal of binary tree
        //traverse left
        // process node
        //traverse right


        //  Your code here
        if (root == null)
            return null;

        // Recursively convert left subtree
        BToDLL(root.left);

        // Now convert this node
        if (prev == null)
            head = root;
        else
        {
            // left node will act as previous node in DLL
            root.left = prev;
            // right node will act as next node in DLL
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree
        BToDLL(root.right);

        return head;
    }
}
