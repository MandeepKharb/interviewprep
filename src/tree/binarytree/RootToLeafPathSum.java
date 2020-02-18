package tree.binarytree;

import java.util.*;
import java.lang.*;
// A Binary Tree node

class BTNod
{
    int data;
    BTNod left, right;

    BTNod(int item)
    {
        data = item;
        left = right = null;
    }
}

class GfG {
    /*you are required to complete this function */

    int actualSum = 0;
    boolean flag = false;

    boolean hasPathSum(BTNod node, int sum) {
        // Your code here
        if (node == null)
            return (sum == 0);
        else
        {
            boolean ans = false;

            /* otherwise check both subtrees */
            int subsum = sum - node.data;
            if (subsum == 0 && node.left == null && node.right == null)
                return true;
            if (node.left != null)
                ans = ans || hasPathSum(node.left, subsum);
            if (node.right != null)
                ans = ans || hasPathSum(node.right, subsum);
            return ans;
        }
    }

}

 public   class RootToLeafPathSum
    {
        // driver function to test the above functions
        public static void main(String args[])
        {
            RootToLeafPathSum ps = new RootToLeafPathSum();
            //Index index_obj = new Index();
            // Input the number of test cases you want to run
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while (t > 0)
            {
                HashMap<Integer, BTNod> m = new HashMap<Integer, BTNod> ();
                int n = sc.nextInt();

                BTNod root = null;

                while (n > 0)
                {

                    int n1 = sc.nextInt();
                    int n2 = sc.nextInt();
                    char lr= sc.next().charAt(0);

                    //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                    BTNod parent = m.get(n1);
                    if (parent == null)
                    {
                        parent = new BTNod(n1);
                        m.put(n1, parent);
                        if (root == null)
                            root = parent;
                    }

                    BTNod child = new BTNod(n2);
                    if (lr == 'L')
                        parent.left = child;
                    else
                        parent.right = child;
                    m.put(n2, child);
                    n--;
                }
                int a = sc.nextInt();

                GfG g = new GfG();
                boolean b = g.hasPathSum(root,a);
                if(b==true)
                    System.out.println(1);
                else
                    System.out.println(0);
                t--;
            }
        }
    }// } Driver Code Ends


/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */




