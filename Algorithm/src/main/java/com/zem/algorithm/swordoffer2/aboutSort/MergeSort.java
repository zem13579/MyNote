package com.zem.algorithm.swordoffer2.aboutSort;

import java.util.Arrays;

public class MergeSort {


    /**
     * 非递归，双重循环方法
     *
     * @param nums
     * @return
     */
    public static int[] mergeSortLoop(int[] nums) {
        int length = nums.length;
        int[] src = nums;
        int[] dst = new int[length];
        for (int seg = 1; seg < length; seg += seg) {
            for (int start = 0; start < length; start += seg * 2) {
                int mid = Math.min(start + seg, length);
                int end = Math.min(start + seg * 2, length);
                int i = start, j = mid, k = start;
                while (i < mid || j < end) {
                    if (j == end || (i < mid && src[i] < src[j])) {
                        dst[k++] = src[i++];
                    } else {
                        dst[k++] = src[j++];
                    }
                }
            }
            int[] temp = src;
            src = dst;
            dst = temp;

        }
        return src;
    }


    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Given array is:");
        System.out.println(Arrays.toString(array));

//        mergeSort(array, 0, array.length - 1);
        int[] result = mergeSortLoop(array);
        System.out.println("\nSorted array is:");
        System.out.println(Arrays.toString(result));
    }

    /**
     * 递归方式，合并排序
     *
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // 找到中间索引
            int mid = left + (right - left) / 2;

            // 递归地将左侧子数组进行归并排序
            mergeSort(array, left, mid);

            // 递归地将右侧子数组进行归并排序
            mergeSort(array, mid + 1, right);

            // 合并两个已排序的子数组
            merge(array, left, mid, right);
        }
    }

    // 该方法用于合并两个已排序的子数组
    public static void merge(int[] array, int left, int mid, int right) {
        // 创建临时数组，用于存放合并后的元素
        int[] temp = new int[right - left + 1];

        // 初始化左右子数组的起始索引
        int i = left, j = mid + 1;
        int k = 0;

        // 比较左右子数组的元素，将较小的元素添加到临时数组中
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        // 将左侧子数组剩余的元素添加到临时数组中
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // 将右侧子数组剩余的元素添加到临时数组中
        while (j <= right) {
            temp[k++] = array[j++];
        }

        // 将临时数组中的元素复制回原数组
        for (i = 0; i < temp.length; i++) {
            array[left + i] = temp[i];
        }
    }

}
