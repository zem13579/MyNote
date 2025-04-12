package com.zem.algorithm.leetcode.learn.part3Sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 */
public class Lt0215 {
    public static void main(String[] args) {
        Lt0215 lt0215 = new Lt0215();
        int kthLargest = lt0215.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            maxQueue.add(num);
        }
        while (k > 1) {
            maxQueue.poll();
            k--;
        }
        return maxQueue.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[k];
        }
        int x = nums[left];
        int i = left - 1;
        int j = right + 1;
        return 0;
    }
}
