package com.zem.algorithm.swordoffer;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class Code14 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reorderOddEven(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reorderOddEven(int[] sourceArr) {
        if (sourceArr == null || sourceArr.length == 0) {
            return;
        }
        int pBegin = 0;
        int pEnd = sourceArr.length - 1;
        while (pBegin < pEnd) {
            //向后移动pBegin，直到它指向偶数
            if (pBegin < pEnd && isaBoolean(sourceArr[pBegin])) {
                pBegin++;
            }
            //向前移动pEnd，直到它指向奇数
            if (pBegin < pEnd && (sourceArr[pEnd] & 0x1) == 0) {
                pEnd--;
            }

            if (pBegin < pEnd) {
                int temp = sourceArr[pBegin];
                sourceArr[pBegin] = sourceArr[pEnd];
                sourceArr[pEnd] = temp;
            }
        }
    }

    private static boolean isaBoolean(int sourceArr) {
        return (sourceArr & 0x1) != 0;
    }
}
