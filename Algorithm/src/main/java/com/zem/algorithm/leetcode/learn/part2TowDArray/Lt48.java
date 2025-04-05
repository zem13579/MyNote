package com.zem.algorithm.leetcode.learn.part2TowDArray;

import java.util.Arrays;

public class Lt48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length - 1;
        int length = matrix.length;
        int starty = 0;
        int startx = 0;
        while (length > 1) {
            for (int i = starty; i < starty + length - 1; i++) {
                int x = startx;
                int y = i;
                int last = matrix[x][y];
                for (int j = 0; j < 4; j++) {
                    int next = matrix[y][m - x];
                    matrix[y][m - x] = last;
                    int lastx = x;
                    x = y;
                    y = m - lastx;
                    last = next;
                }
            }
            length -= 2;
            startx++;
            starty++;
        }

    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Lt48().rotate(ints);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
