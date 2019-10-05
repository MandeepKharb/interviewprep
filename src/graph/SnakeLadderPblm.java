package graph;

import java.util.Scanner;

public class SnakeLadderPblm {
    static int min;
    static class Node{
        // Node is kind of pair class where it has a src and dest
        // val here is src and next is dest
        //dest is -1 for the pair where  no snake  and ladder is encountered
        // else dest or next is the next value we reach if we encounter snake or ladder
        int next = -1;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    public static void dfs(Node[] node, int index, int count, int[] visited){
        // exit condition if we reach the index 30
        if(index == 30){
            min = Math.min(min, count);
            return;
        }
        if(min != Integer.MAX_VALUE && min < count){
            return;
        }

        // if visited then return
        if(visited[index] == 1){
            return;
        }
        visited[index] = 1;
        for(int i = 1; i <= 6; i++){
            int newIndex = index + i;
            if(newIndex > 30){
                break;
            }
            if(node[newIndex].next != -1){
                //if there is snake or ladder at next index
                dfs(node, node[newIndex].next, count + 1, visited);
            }else{
                // no snake or ladder just moved next
                dfs(node, newIndex, count + 1, visited);
            }
        }
        visited[index] = 0;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            Node[] node = new Node[31];
            min = Integer.MAX_VALUE;
            for(int i = 1; i <= 30; i++){
                node[i] = new Node(i);
            }
            int pair = sc.nextInt(); // number of pair where snake or ladder are present
            for(int i = 1; i <= pair; i++){


                int src = sc.nextInt();
                int dest = sc.nextInt();
                node[src].next = dest;
            }

            dfs(node, 1, 0, new int[31]);
            System.out.println(min);
        }
    }
}
