package tree.binarytree;


/*
* Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Following is an example of SumTree.

          26
        /   \
      10     3
    /    \     \
  4      6      3
* */
class Nodee
{
    int data;
    Nodee left, right, nextRight;

    Nodee(int item)
    {
        data = item;
        left = right = nextRight = null;
    }
}

public class SumTree {



    Nodee root;

    /* A utility function to get the sum of values in tree with root
     as root */
    int sum(Nodee nodee)
    {
        if (nodee == null)
            return 0;
        return sum(nodee.left) + nodee.data + sum(nodee.right);
    }

    /* returns 1 if sum property holds for the given
       node and both of its children */
    int isSumTree(Nodee nodee)
    {
        int ls, rs;

        /* If node is NULL or it's a leaf node then
           return true */
        if ((nodee == null) || (nodee.left == null && nodee.right == null))
            return 1;

        /* Get sum of nodes in left and right subtrees */
        ls = sum(nodee.left);
        rs = sum(nodee.right);

        /* if the node and both of its children satisfy the
           property return 1 else 0*/
        if ((nodee.data == ls + rs) && (isSumTree(nodee.left) != 0)
                && (isSumTree(nodee.right)) != 0)
            return 1;

        return 0;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        SumTree tree = new SumTree();
        tree.root = new Nodee(26);
        tree.root.left = new Nodee(10);
        tree.root.right = new Nodee(3);
        tree.root.left.left = new Nodee(4);
        tree.root.left.right = new Nodee(6);
        tree.root.right.right = new Nodee(3);

        if (tree.isSumTree(tree.root) != 0)
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
    }
}
