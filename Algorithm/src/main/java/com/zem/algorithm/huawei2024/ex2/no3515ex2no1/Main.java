package com.zem.algorithm.huawei2024.ex2.no3515ex2no1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static int count = 0;
    static boolean can = false;
    static  int m;
    static  int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] map = new int[m][n];

        List<int[]> people = new ArrayList<>();
        List<int[]> restaurants = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tag = sc.nextInt();
                map[i][j] = tag;
                int[] tmp = {i, j};
                switch (tag) {
                    case 2:
                        people.add(tmp);
                        break;
                    case 3:
                        restaurants.add(tmp);
                        break;
                }
            }
        }

        for (int[] restaurant : restaurants) {
            int[] p1 = people.get(0);
            int[] p2 = people.get(1);
            if (canArrive(restaurant, p1, map) && canArrive(restaurant, p2, map)) {
                count++;
            }
        }

        System.out.println(count);

    }

    private static boolean canArrive(int[] restaurant, int[] p1, int[][] map ) {
        int[][] visited = new int[m][n];
        myDfs(map, p1[0], p1[1], restaurant[0], restaurant[1], visited);
        boolean result = can;
        can = false;
        return result;
    }

    private static void myDfs(int[][] map, int i, int j, int targetI, int targetJ, int[][] visited) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] == 1 || visited[i][j] == 1) {
            return;
        }
        if (i == targetI && j == targetJ) {
            can = true;
            return;
        }
        visited[i][j] = 1;
        myDfs(map, i + 1, j, targetI, targetJ, visited);
        myDfs(map, i - 1, j, targetI, targetJ, visited);
        myDfs(map, i, j + 1, targetI, targetJ, visited);
        myDfs(map, i, j - 1, targetI, targetJ, visited);
    }

}
