package tree.binarytree;

public class BTRightView {
    static int maxlevel;
    void rightView(Node root)
    {
        // Your code here
        maxlevel=0;
        printRight(root, 1);
        //System.out.println();
    }

    void printRight(Node root, int level){

        if(root==null) return;

        if(level>maxlevel){
            System.out.print(root.data+" ");
            maxlevel=level;
        }


        printRight(root.right, level+1);
        printRight(root.left, level+1);
    }
}
