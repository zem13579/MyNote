package com.zem.algorithm.leetcode.learn.part1Array;

public class Lt485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Lt485 lt485 = new Lt485();
        System.out.println(lt485.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1,3,4,1,1,1,1,1}));
    }
}
