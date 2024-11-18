
package com.example.demo;

public class JavaTest {

    public int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    c++;
                    matrixCount(grid, i, j);
                }
            }
        }
        return c;
    }

    void matrixCount(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {return;}
        grid[row][col] = 0;
        matrixCount(grid, row + 1, col);
        matrixCount(grid, row - 1, col);
        matrixCount(grid, row, col + 1);
        matrixCount(grid, row, col - 1);
        matrixCount(grid, row + 1, col + 1);
        matrixCount(grid, row - 1, col - 1);
        matrixCount(grid, row + 1, col - 1);
        matrixCount(grid, row - 1, col + 1);
    }

    public static void main(String[] args) {
        JavaTest test = new JavaTest();
        int[][] grid = { { 0, 0, 0,0 }, { 0, 1, 0 ,1}, { 0, 0, 0 } };
        int c = test.countIslands(grid);
        System.out.println("countIslands: " + c);

    }
}
