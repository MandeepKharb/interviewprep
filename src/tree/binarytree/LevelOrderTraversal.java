package tree.binarytree;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void traverse(Node root){
        LinkedList<Node> linkedList= new LinkedList<Node>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            Node node = linkedList.pop();
            System.out.println(node.data);
            if(node.left!=null)
                linkedList.add(node.left);
            if(node.right!=null)
                linkedList.add(node.right);
        }
    }
}
