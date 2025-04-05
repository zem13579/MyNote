package com.zem.algorithm.leetcode.learn.part2TowDArray;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = {3, 2, 1, 4};
        test.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = false;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
