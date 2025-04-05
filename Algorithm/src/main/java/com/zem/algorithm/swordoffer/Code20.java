package com.zem.algorithm.swordoffer;

/**
 * @Author zem
 * @Date 2023/10/18
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。例如：如果输入如下矩阵
 */
public class Code20 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        printMatrix(arr);
    }

    private static void printMatrix(int[][] arr) {
        int columns = 1;
        int rows = 1;
        doPrintMartix(arr, columns, rows);
    }

    private static void doPrintMartix(int[][] arr, int columns, int rows) {
        if (arr == null || columns == 0 || rows == 0) {
            return;
        }
        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            doPrintMartix(arr, columns, rows);
            start++;
        }
    }


}
