package com.zem.algorithm.leetcode.learn.part2TowDArray;

import java.util.ArrayList;
import java.util.List;

public class Lt54 {

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length;
        int colums = matrix[0].length;
        int left = 0, right = colums - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int colnow = left; colnow <= right; colnow++) {
                order.add(matrix[top][colnow]);
            }
            for (int rowNow = top + 1; rowNow <= bottom; rowNow++) {
                order.add(matrix[rowNow][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directArr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directIndex = 0;

        int total = rows * cols;
        int row = 0, col = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directArr[directIndex][0];
            int nextCol = col + directArr[directIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directIndex = (directIndex + 1) % 4;
            }
            row = row + directArr[directIndex][0];
            col = col + directArr[directIndex][1];
        }

        return order;

    }

    public static void main(String[] args) {
        System.out.println(new Lt54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
