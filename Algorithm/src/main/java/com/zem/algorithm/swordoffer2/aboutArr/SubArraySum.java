package com.zem.algorithm.swordoffer2.aboutArr;

import java.util.HashMap;

public class SubArraySum {
    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        int[] arr = {1, 1, 1};
        System.out.println(subArraySum.subArraySum(arr, 2));
    }

    public int subArraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);//前0个数字之和，出现1次
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
