package com.zem.algorithm.huawei2024.ex2.no2539ex2no12;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int t = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[h][w];
        for (int i = 0; i < h; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < w; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }
        sc.close();
        System.out.println(countOnes(w, h, x, y, sx, sy, t, matrix));

    }

    private static int countOnes(int w, int h, int x, int y, int sx, int sy, int t, int[][] matrix) {
        int count = matrix[y][x];

        while (t-- > 0) {
            x += sx;
            y += sy;

            if (y < 0) {
                y = -y;
                sy = -sy;
            }
            if (x < 0) {
                x = -x;
                sx = -sx;
            }

            //left right
            if (x == 0 || x == w - 1) {
                sx = -sx;
            }

            // up down
            if (y == 0 || y == h - 1) {
                sy = -sy;
            }
            count += matrix[y][x];
        }
        return count;
    }
}
