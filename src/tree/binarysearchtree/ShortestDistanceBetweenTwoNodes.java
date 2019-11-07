package tree.binarysearchtree;


/*
* We have discussed distance between two nodes in binary tree. The time complexity of this solution is O(n)

In the case of BST, we can find the distance faster. We start from the root and for every node, we do following.

If both keys are greater than the current node, we move to the right child of the current node.
If both keys are smaller than current node, we move to left child of current node.
If one keys is smaller and other key is greater, current node is Lowest Common Ancestor (LCA) of two nodes. We find distances of current node from two keys and return sum of the distances.
* */
public class ShortestDistanceBetweenTwoNodes {

    // Returns minimum distance beween a and b.
// This function assumes that a and b exist
// in BST.
    // in this example we assume that a < b
    static int distanceBetween2(Node root, int a, int b)
    {
        if (root == null)
            return 0;

        // Both keys lie in left
        if (root.data > a && root.data > b)
            return distanceBetween2(root.left, a, b);

        // Both keys lie in right
        if (root.data < a && root.data < b) // same path
            return distanceBetween2(root.right, a, b);

        // Lie in opposite directions (Root is
        // LCA of two nodes)
        if (root.data >= a && root.data <= b)
            return distanceFromRoot(root, a) + distanceFromRoot(root, b);

        return 0;
    }

    // This function returns distance of x from
// root. This function assumes that x exists
// in BST and BST is not NULL.
    static int distanceFromRoot(Node root, int x)
    {
        if (root.data == x)
            return 0;
        else if (root.data > x)
            return 1 + distanceFromRoot(root.left, x);
        return 1 + distanceFromRoot(root.right, x);
    }
}
