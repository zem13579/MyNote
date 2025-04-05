package com.zem.algorithm.leetcode.huawei;

public class Lt53 {
    public static void main(String[] args) {
        Lt53 lt53 = new Lt53();
        lt53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    public int maxSubArray(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int maxSubSum = Integer.MIN_VALUE;

        int[] minSubSumArr = new int[nums.length];
        for (int i = 1; i < prefixSum.length; i++) {
            minSubSumArr[i] = Math.min(Math.min(minSubSumArr[i - 1], prefixSum[i - 1]), 0);
        }

        for (int i = 0; i < prefixSum.length; i++) {
            maxSubSum = Math.max(maxSubSum, prefixSum[i] - minSubSumArr[i]);
        }

        return maxSubSum;

    }

}
