package tree.binarytree;

import java.util.Scanner;

class BTNode {
    int data;
    BTNod left,right;
    BTNode(int d)
    {
        data=d;
        left=right=null;
    }
}
class ConstructTreeFromGivenArrayInPreOrder
{
    public static void inorder(BTNod root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []pre=new int[n];
            char []preLN=new char[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                pre[i]=b;
            }
            for(int i=0;i<n;i++)
            {
                char c=sc.next().charAt(0);
                preLN[i]=c;
            }
            GFG obj=new GFG();
            BTNod root=obj.constructTree(n,pre,preLN);
            inorder(root);
            System.out.println();
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/
//Function should return the root of the formed binary tree.
class GFG
{
    
    int index=0;
    BTNod constructTree(int n, int pre[], char preLN[]) {
        //Add your code here.

        if (index > n)
            return null;
        BTNod node = new BTNod(pre[index]);
        if (preLN[index++] == 'N') {
            node.left = constructTree(index, pre, preLN);
            node.right = constructTree(index, pre, preLN);
        }

        return node;
    }   }