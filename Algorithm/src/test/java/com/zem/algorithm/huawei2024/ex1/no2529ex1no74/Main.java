package com.zem.algorithm.huawei2024.ex1.no2529ex1no74;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row = sc.nextInt();
        int col = (int) Math.ceil((double) n / row);
        sc.close();

        String[][] arr = new String[row][col];

        for (String[] strings : arr) {
            Arrays.fill(strings, "*");
        }

        int num = 1;
        //初始边界
        int top = 0, bottom = row - 1, left = 0, right = col - 1;

        while (num <= n) {
            for (int i = left; i <= right && num <= n; i++) {

                arr[top][i] = String.valueOf(num++);
            }
            top++;


            for (int i = top; i <= bottom && num <= n; i++) {
                if (num > n) {
                    break;
                }
                arr[i][right] = String.valueOf(num++);
            }
            right--;

            for (int i = right; i >= left && num <= n; i--) {
                arr[bottom][i] = String.valueOf(num++);
            }
            bottom--;

            for (int i = bottom; i >= top && num <= n; i--) {

                arr[i][left] = String.valueOf(num++);
            }
            left++;
        }

        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}