package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

       private int V;
        //linkedlist type array
      private   LinkedList<Integer> adjList[];
    DFS(int v){
            this.V=v;
        adjList = new LinkedList[v];
        for (int i =0;i<v;++i){
                adjList[i]=new LinkedList<Integer>();
            }
        }

        private  void addEdge(int u, int v){

            adjList[u].add(v);
            adjList[v].add(u);

        }


     void dfs(int v){
        boolean visited[] = new boolean[V];
         dfsUtil(v,visited);
    }
      void dfsUtil(int v, boolean visited[]){
        visited[v]=true;
        System.out.println(v);
        Iterator<Integer> itr =adjList[v].iterator();
        while (itr.hasNext()){
            int temp =itr.next();
            if(!visited[temp]){
                visited[temp]=true;
                dfsUtil(temp,visited);

            }
        }


    }

    public static void main(String args[])
    {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.dfs(2);
    }

}
