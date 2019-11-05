package tree.binarytree;

// A Binary Tree node



public class CountOfNodesGreaterThanGivenNode {



    public static int nodesGreaterThanX(Node node, int k) {
        if (node == null) {
            return 0;
        }

        int countLeft = nodesGreaterThanX(node.left, k);
        int countRight = nodesGreaterThanX(node.right, k);

        return (node.data > k ? 1 : 0) + countLeft + countRight;
    }
}
