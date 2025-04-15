package com.zem.algorithm.leetcode.learn.part3Sort;

import java.util.Arrays;
import java.util.Random;

public class Lt912 {

    public static void main(String[] args) {
        int[] arr = {110, 100, 0};
        Lt912 lt912 = new Lt912();
        int[] ints = lt912.sortArray(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortArray(int[] nums) {
        this.qickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void qickSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = this.partition(nums, low, high);
            qickSort(nums, low, p - 1);
            qickSort(nums, p + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int random = new Random().nextInt(high - low + 1) + low;
        swap(nums,high,random);
        int pValue = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pValue) {
                i++;
                this.swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);

        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
