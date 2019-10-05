package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    private int V;
    //linkedlist type array
    private LinkedList<Integer> adjList[];
    BFS(int v){
        this.V=v;
        adjList = new LinkedList[v];
        for (int i =0;i<v;++i){
            adjList[i]=new LinkedList<Integer>();
        }
    }

    private  void addEdge(int u, int v){

        adjList[u].add(v);


    }

    void bfs(int s){
        boolean visited[]= new boolean[V];


        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }



    }



    public static void main(String args[])
    {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bfs(2);
    }
}
