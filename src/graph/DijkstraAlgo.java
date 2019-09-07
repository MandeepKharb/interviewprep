package graph;

public class DijkstraAlgo {

// number of vertex in adj matrix .
    static final int V=5;

    private static void dijkstra(int graph[][],int src)
    {
        // create an int array of length same as to number of vertices or length of 2d adjancy matrix
        // since we have 9 vertices in our matrix so we will
        int distance[] = new int [V]; // this array is going to be the O/P array which will be holding min distance of vertices from the source vertex.

        // take a boolean array to track the vertex which are visited.
        // offcourse this would be of same length as number of vertex we have
        boolean visited[] = new boolean[V];

        // initially we initialize these array as below
        // Initialize all distances as INFINITE and visited[] as false

        for (int i = 0; i <V; i++){
            distance[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }

        distance[src]=0; // distance from source node to itself is zero

        for(int i=0;i<V;i++){

            int index_MinDistVertex = minDistanceVertex(distance,visited);

            visited[index_MinDistVertex] = true;

            for (int j =0; j<V; j++)
                if (visited[j] ==false && graph[index_MinDistVertex][j] != 0 && distance[index_MinDistVertex] != Integer.MAX_VALUE && distance[index_MinDistVertex] + graph[index_MinDistVertex][j] < distance[j])
                {
                    distance[j] = distance[index_MinDistVertex]+graph[index_MinDistVertex][j];
                }



        }


        printSolution(distance,V);

    }
/*
* Print the solution
* */
    private static void printSolution(int distance[], int V ){

            System.out.println("Vertex   Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + " tt " + distance[i]);

    }
    /*
    * This method will return the vertex with the minimum distance
    * */
    private static int minDistanceVertex(int distance[], boolean visited[]){
        int minDistance = Integer.MAX_VALUE;
        int indexOfMinDistanceVertex=-1;

        for (int i =0; i<V;i++)
            if(visited[i]==false && distance[i]<minDistance)
            {
                minDistance = distance[i];
                indexOfMinDistanceVertex=i;
            }

        return indexOfMinDistanceVertex;
    }

    public static void main(String[] args)
    {
        // below is a 2d matrix or adjancy matrix of a given graph . this will go as input in method named as dijkstra
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0 },
                { 4, 0, 8, 0, 0},
                { 0, 8, 0, 7, 0 },
                { 0, 0, 7, 0, 9},
                { 0, 0, 0, 9, 0} };
        DijkstraAlgo t = new DijkstraAlgo();
        t.dijkstra(graph, 0);
    }
}
