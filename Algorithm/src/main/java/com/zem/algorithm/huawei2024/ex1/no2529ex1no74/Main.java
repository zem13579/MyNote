package com.zem.algorithm.huawei2024.ex1.no2529ex1no74;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/13 0013 17:09
 */
public class Main {
    static int num;
    static int row;
    static int col;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        row = sc.nextInt();
        col = (int) Math.ceil((double) num / row);
        String[][] arr = new String[row][col];
        for (String[] strings : arr) {
            Arrays.fill(strings, "*");
        }
        leftToRight(arr, 0, 0, 1);
        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static void leftToRight(String[][] arr, int i, int j, int curNum) {
        if (!"*".equals(arr[i][j])) {
            return;
        }
        while (j < col && "*".equals(arr[i][j]) && curNum <= num) {
            arr[i][j] = curNum + "";
            j++;
            curNum++;
        }
        if (curNum > num) {
            return;
        }
        upToDown(arr, i + 1, j - 1, curNum);
    }

    private static void upToDown(String[][] arr, int i, int j, int curNum) {
        if (!"*".equals(arr[i][j])) {
            return;
        }
        while (i < row && "*".equals(arr[i][j]) && curNum <= num) {
            arr[i][j] = curNum + "";
            i++;
            curNum++;
        }
        if (curNum > num) {
            return;
        }
        rightToLeft(arr, i - 1, j - 1, curNum);
    }

    private static void rightToLeft(String[][] arr, int i, int j, int curNum) {
        if (!"*".equals(arr[i][j])) {
            return;
        }
        while (j > -1 && "*".equals(arr[i][j]) && curNum <= num) {
            arr[i][j] = curNum + "";
            j--;
            curNum++;
        }
        if (curNum > num) {
            return;
        }
        downToUp(arr, i - 1, j + 1, curNum);
    }

    private static void downToUp(String[][] arr, int i, int j, int curNum) {
        if (!"*".equals(arr[i][j])) {
            return;
        }
        while (i > -1 && "*".equals(arr[i][j]) && curNum <= num) {
            arr[i][j] = curNum + "";
            i--;
            curNum++;
        }
        if (curNum > num) {
            return;
        }
        leftToRight(arr, i + 1, j + 1, curNum);
    }
}
