

/*
* A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down.
In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path from source to destination. Note that this is a simple version of the typical Maze problem. For example, a more complex version can be that the rat can move in 4 directions and a more complex version can be with a limited number of moves.

Following is an example maze.

                {1, 0, 0, 0}
                {1, 1, 0, 1}
                {0, 1, 0, 0}
                {1, 1, 1, 1}
*
* */

package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class RatNMaze {

    public static ArrayList<String> printPath(int[][] mat, int n) {
        boolean visited[][] = new boolean[n][n];
        Cell currCell = new Cell(0, 0, n);
        visited[0][0] = true;
        ArrayList<String> result = new ArrayList<>();
        findPath(mat, n, currCell, visited, "", result);

        return result;
    }

    private static void findPath(int[][] mat, int n, Cell currCell, boolean visited[][], String path, ArrayList<String> result) {

        if (currCell.row == n - 1 && currCell.col == n - 1) {
// 			System.out.print(path +" ");
            result.add(path);
        }

        Cell upCell = new Cell(currCell.row - 1, currCell.col, n);
        Cell downCell = new Cell(currCell.row + 1, currCell.col, n);
        Cell rightCell = new Cell(currCell.row, currCell.col + 1, n);
        Cell leftCell = new Cell(currCell.row, currCell.col - 1, n);

        if (checkCell(mat, visited, downCell, n)) {
            visited[downCell.row][downCell.col] = true;
            findPath(mat, n, downCell, visited, path + "D", result);
            visited[downCell.row][downCell.col] = false;
        }
        if (checkCell(mat, visited, leftCell, n)) {
            visited[leftCell.row][leftCell.col] = true;
            findPath(mat, n, leftCell, visited, path + "L", result);
            visited[leftCell.row][leftCell.col] = false;
        }
        if (checkCell(mat, visited, rightCell, n)) {
            visited[rightCell.row][rightCell.col] = true;
            findPath(mat, n, rightCell, visited, path + "R", result);
            visited[rightCell.row][rightCell.col] = false;
        }
        if (checkCell(mat, visited, upCell, n)) {
            visited[upCell.row][upCell.col] = true;
            findPath(mat, n, upCell, visited, path + "U", result);
            visited[upCell.row][upCell.col] = false;
        }


    }

    private static boolean checkCell(int[][] mat, boolean visited[][], Cell cell, int n) {
        if (cell.row != -1 && !visited[cell.row][cell.col] && mat[cell.row][cell.col] == 1) {
            return true;
        }
        return false;
    }

    static class Cell {
        int row;
        int col;

        Cell(int row, int col, int n) {
            if (row < n && col < n && row >= 0 && col >= 0) {
                this.row = row;
                this.col = col;
            } else {
                this.row = -1;
                this.col = -1;
            }
        }

    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        int n = maze.length;
        System.out.println( printPath(maze,n));

    }
}