package com.zem.algorithm.swordoffer;

import java.util.Random;

/**
 * 数组中的逆序对
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Code36 {

    public static void main(String[] args) {
        int[] arr = new int[10000000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        // 57 46
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        Code36 code36 = new Code36();

        long start1 = System.nanoTime();
        System.out.println(code36.inversePairsWithMerge(arr));
        long end1 = System.nanoTime();
        System.out.println(end1 - start1);


        long start2 = System.nanoTime();
        System.out.println(code36.inversePairs(arr2));
        long end2 = System.nanoTime();
        System.out.println(end2 - start2);


    }

    public int inversePairs(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
//                    System.out.println(data[i] + "," + data[j]);
                    count++;
                }
            }
        }
        return count;
    }

    private int countReverse = 0;

    /**
     * 通过类似归并排序的算法 将算法的复杂度降到常数级别
     *
     * @param data
     */
    public int inversePairsWithMerge(int[] data) {
        if (data == null) {
            return 0;
        }
        fun1(data, 0, data.length - 1);
        return countReverse;
    }

    private void fun1(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            fun1(arr, left, mid);
            fun1(arr, mid + 1, right);
            fun2(arr, left, mid, right);
        }
    }

    private void fun2(int[] arr, int left, int mid, int right) {
        //创建临时数组，将原数组复制到临时数组中去
        int leftArrLength = mid - left + 1;
        int rightArrlength = right - mid;
        int[] L = new int[leftArrLength];
        int[] R = new int[rightArrlength];
        System.arraycopy(arr, left, L, 0, leftArrLength);
        System.arraycopy(arr, mid + 1, R, 0, rightArrlength);

        //开始归并到原数组
        int i = leftArrLength - 1, j = rightArrlength - 1, k = right;
        while (i >= 0 && j >= 0) {
            //取较小的值放入数组
            if (L[i] > R[j]) {
                //逆序对的数目等于第二个子数组中剩余数字的个数
                countReverse += j + 1;
                arr[k--] = L[i--];
            } else {
                arr[k--] = R[j--];
            }
        }

        //将剩余元素复制到 arr[]
        while (i >= 0) {
            arr[k--] = L[i--];
        }
        while (j >= 0) {
            arr[k--] = R[j--];
        }
    }
}
