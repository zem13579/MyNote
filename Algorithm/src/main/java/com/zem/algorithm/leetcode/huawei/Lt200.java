package com.zem.algorithm.leetcode.huawei;

public class Lt200 {
    public static void main(String[] args) {
        Lt200 lt200 = new Lt200();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(lt200.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] used = new boolean[m][n];

        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    this.dfs(grid, used, m, n, i, j);
                    counter++;
                }
            }
        }
        return counter;

    }

    private void dfs(char[][] grid, boolean[][] used, int m, int n, int i, int j) {

        int[][] forward = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        //left
        for (int[] ints : forward) {
            int x = i + ints[0];
            int y = j + ints[1];
            if (x >= 0 && x < m && y >= 0 && y < n && !used[x][y] && grid[x][y] == '1') {
                used[x][y] = true;
                dfs(grid, used, m, n, x, y);
            }
        }

    }
}
