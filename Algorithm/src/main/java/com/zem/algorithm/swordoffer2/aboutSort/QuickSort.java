package com.zem.algorithm.swordoffer2.aboutSort;


import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class QuickSort {

    public static void main(String[] args) {
        int[] ints = new QuickSort().sortArray(new int[]{4, 1, 5, 3, 6, 2, 7, 8});
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int start, int end) {
        if (end > start) {
            int pivot = partition(nums, start, end);
            quicksort(nums, start, pivot - 1);
            quicksort(nums, pivot + 1, end);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        int random = ThreadLocalRandom.current().nextInt(end - start + 1) + start;
        swap(nums, random, end);
        int small = start - 1;
        for (int i = start; i <= end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, small, i);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private static void swap(int[] nums, int i1, int i2) {
        if (i1 != i2) {
            int tmp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = tmp;
        }
    }
}
