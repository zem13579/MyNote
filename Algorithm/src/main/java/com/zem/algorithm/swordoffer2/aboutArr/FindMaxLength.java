package com.zem.algorithm.swordoffer2.aboutArr;

import java.util.HashMap;

/**
 * 面试题11：0和1个数相同的子数组
 */
public class FindMaxLength {
    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {
        // key 数字之和
        // value 数组下标
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            //将0替换为-1
            sum += nums[i] == 0 ? -1 : 1;
            //如果数组中前i个数字之和为m，前j个数字（j>i）之和也为m，
            //那么从第i+1个数字到第j个数字的子数组的数字之和为0，这个和为0的子数组的长度是j-i
            if (sumToIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }

        return maxLength;

    }
}
