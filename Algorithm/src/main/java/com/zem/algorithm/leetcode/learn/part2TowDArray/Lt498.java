package com.zem.algorithm.leetcode.learn.part2TowDArray;

import java.util.Arrays;

public class Lt498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int x = mat.length;
        int y = mat[0].length;
        int[] result = new int[x * y];
        int index = 0;
        int i = 0;
        int j = 0;
        boolean isUp = true;
        while (!(i == x - 1 && j == y - 1)) {
            result[index++] = mat[i][j];
            if (isUp) {
                if (i - 1 >= 0 && j + 1 <= y - 1) {
                    i = i - 1;
                    j = j + 1;
                } else {
                    isUp = false;
                    if (j + 1 <= y - 1) {
                        j = j + 1;
                    } else {
                        i = i + 1;
                    }
                }
            } else {
                if (j - 1 >= 0 && i + 1 <= x - 1) {
                    j = j - 1;
                    i = i + 1;
                } else {
                    isUp = true;
                    if (i + 1 <= x - 1) {
                        i = i + 1;
                    } else {
                        j = j + 1;
                    }
                }
            }
        }
        result[index] = mat[i][j];
        return result;

    }

    public static void main(String[] args) {
        Lt498 lt498 = new Lt498();
        int[] diagonalOrder = lt498.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(diagonalOrder));
    }
}
