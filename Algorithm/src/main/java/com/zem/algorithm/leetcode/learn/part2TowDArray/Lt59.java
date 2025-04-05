package com.zem.algorithm.leetcode.learn.part2TowDArray;

import java.util.Arrays;

public class Lt59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int counter = 1;
        int row = 0;
        int col = 0;
        int[][] directArr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direct = 0;
        for (int i = 0; i < n * n; i++) {
            ans[row][col] = counter;
            visited[row][col] = true;
            counter++;
            int nextRow = row + directArr[direct][0];
            int nextCol = col + directArr[direct][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                direct = (direct + 1) % 4;
            }
            row += directArr[direct][0];
            col += directArr[direct][1];

        }
        return ans;
    }

    public static void main(String[] args) {
        Lt59 lt59 = new Lt59();
        int[][] ints = lt59.generateMatrix(3);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
