package com.zem.algorithm.huawei2024.ex1.no3398ex1no44;

import java.util.Scanner;

public class Main {

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(map, 0, 0);
        System.out.println(count);
    }

    /**
     *
     * @param map
     * @param row 行的index
     * @param col 列的index
     */
    private static void dfs(int[][] map, int row, int col) {
        //遇到终点
        if (row == map.length - 1 && col == map[0].length - 1) {
            count++;
            return;
        }
        //向右
        if (col + 1 < map[0].length && map[row][col + 1] != 1) {
            map[row][col + 1] = 1;
            dfs(map, row, col + 1);
            map[row][col + 1] = 0;
        }

        //向下
        if (row + 1 < map.length && map[row + 1][col] != 1) {
            map[row + 1][col] = 1;
            dfs(map, row + 1, col);
            map[row + 1][col] = 0;
        }

    }
}
