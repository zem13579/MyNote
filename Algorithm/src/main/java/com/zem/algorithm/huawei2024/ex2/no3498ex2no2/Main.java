package com.zem.algorithm.huawei2024.ex2.no3498ex2no2;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[][] visited = new int[n][m];
        int max = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j] != 1 && map[i][j] != 0) {
                    int cur = mydfs(map, i, j, visited);
                    if (cur > max) {
                        max = cur;
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static int mydfs(int[][] map, int i, int j, int[][] visited) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length ||
                map[i][j] == 0 || visited[i][j] == 1) {
            return 0;
        }
        visited[i][j] =1;
        return mydfs(map, i + 1, j, visited) +
                mydfs(map, i, j + 1, visited) +
                mydfs(map, i - 1, j, visited) +
                mydfs(map, i, j - 1, visited) + 1;
    }
}
