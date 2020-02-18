
// check tow given trees are idenctical
package tree.binarytree;

public class TwoTreesAreIdentical {

    boolean isIdentical(BTNod root1, BTNod root2)
    {
        //Your code here

        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        return (root1.data == root2.data && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right));
    }
}
