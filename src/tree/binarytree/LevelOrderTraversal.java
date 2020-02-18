package tree.binarytree;

import java.util.LinkedList;

public class LevelOrderTraversal {

    public static void traverse(BTNod root){
        LinkedList<BTNod> linkedList= new LinkedList<BTNod>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            BTNod node = linkedList.pop();
            System.out.println(node.data);
            if(node.left!=null)
                linkedList.add(node.left);
            if(node.right!=null)
                linkedList.add(node.right);
        }
    }
}
