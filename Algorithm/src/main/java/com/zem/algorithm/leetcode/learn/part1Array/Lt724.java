package com.zem.algorithm.leetcode.learn.part1Array;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2025/3/17 0017 16:46
 */
public class Lt724 {
    
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int right = sum - left - nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
