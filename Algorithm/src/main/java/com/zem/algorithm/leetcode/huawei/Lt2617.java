package com.zem.algorithm.leetcode.huawei;

public class Lt2617 {
    public static void main(String[] args) {
        Lt2617 lt2617 = new Lt2617();
//        int[][] input = {{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}, {2, 4, 0, 0}};
        int[][] input = {{0, 1, 0}};
        System.out.println(lt2617.minimumVisitedCells(input));
    }


    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] stepGrid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                stepGrid[i][k] = Integer.MAX_VALUE;
            }
        }
        stepGrid[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (stepGrid[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                int start;
                if (j > 1 && stepGrid[i][j-1] == stepGrid[i][j]) {
                    start = grid[i][j-1] + j;
                } else {
                    start = j + 1;
                }
                for (int y = start; y < n && y <= grid[i][j] + j; y++) {
                    int step = stepGrid[i][j] + 1;
                    if (step < stepGrid[i][y]) {
                        stepGrid[i][y] = step;
                    }
                }
                if (i > 1 && stepGrid[i-1][j] == stepGrid[i][j]) {
                    start = grid[i-1][j] + i;
                } else {
                    start = i + 1;
                }
                for (int x = start; x < m && x <= grid[i][j] + i; x++) {

                    int step = stepGrid[i][j] + 1;
                    if (step < stepGrid[x][j]) {
                        stepGrid[x][j] = step;
                    }
                }
            }
        }
        if (stepGrid[m - 1][n - 1] != Integer.MAX_VALUE) {
            return stepGrid[m - 1][n - 1];
        } else {
            return -1;
        }
    }

}
