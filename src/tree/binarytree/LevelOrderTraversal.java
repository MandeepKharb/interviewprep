package tree.binarytree;

import java.util.LinkedList;

public class LevelOrderTraversal {

    public static void traverse(BTNode root){
        LinkedList<BTNode> linkedList= new LinkedList<BTNode>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            BTNode node = linkedList.pop();
            System.out.println(node.data);
            if(node.left!=null)
                linkedList.add(node.left);
            if(node.right!=null)
                linkedList.add(node.right);
        }
    }
}
