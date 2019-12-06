package tree.binarytree;

public class BTLeftView {
    static int maxlevel;
    void leftView(BTNode root)
    {
        // Your code here
        maxlevel=0;
        printleft(root, 1);
        //System.out.println();
    }

    void printleft(BTNode root, int level){

        if(root==null) return;

        if(level>maxlevel){
            System.out.print(root.data+" ");
            maxlevel=level;
        }

        printleft(root.left, level+1);
        printleft(root.right, level+1);
    }
}
