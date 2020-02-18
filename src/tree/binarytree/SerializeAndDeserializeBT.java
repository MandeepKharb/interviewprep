package tree.binarytree;

import java.util.ArrayList;



class TNode {
    int val;
    TNode left;
    TNode right;
    TNode(int x) { val = x; }
}
public class SerializeAndDeserializeBT {


// this method traverse the tree in preorder and serialize it into arraylist
    public void serialize(TNode root, ArrayList arr){
        if (root == null)
        {
            arr.add(-1);  // adding -1 to arraylist if node is null
            return;

        }

        arr.add(root.val);
        serialize(root.left,arr);
        serialize(root.right,arr);
    }



    int index =0; // thix deserializtion is from arraylist whose element are inserted in preorder
    public TNode deserialize(ArrayList<Integer>arr){
        if (index == arr.size() || arr.get(index)==-1) {
            index+=1;
            return null;
        }

        TNode root = new TNode(arr.get(index));
        index+=1;
        root.left=deserialize(arr);
        root.right =deserialize(arr);
        return root;
    }
}
