package com.zem.algorithm.swordoffer2.aboutBinSearch;

import java.util.Arrays;

/**
 * 题目：输入一个排序的整数数组nums和一个目标值t，如果数组nums中包含t，则返回t在数组中的下标；如果数组nums中不包含t，
 * 则返回将t按顺序插入数组nums中的下标。
 * 假设数组中没有相同的数字。例如，输入数组nums为[1，3，6，8]，如果目标值t为3，则输出1；如果t为5，则返回2
 */
public class SearchInsert {

    public static void main(String[] args) {
//        System.out.println(searchInsert(new int[]{2, 3, 6, 8}, 1));
        System.out.println(searchInsert2(new int[]{2, 3, 6, 8}, 3));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left > nums.length - 1) {
            return nums.length;
        } else if (left == 0) {
            return 0;
        } else {
            return left + 1;
        }
    }

    public static int searchInsert2(int[] nums, int target) {
        return Arrays.binarySearch(nums, target);
    }
}
