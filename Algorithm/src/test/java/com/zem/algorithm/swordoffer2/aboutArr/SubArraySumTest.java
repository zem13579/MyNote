package com.zem.algorithm.swordoffer2.aboutArr;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

class SubArraySumTest {

    @Test
    public void test(){
        System.out.println(subArrSum(new int[]{1, 1, 1}, 2));
        System.out.println(subArrSum(new int[]{1, 1, 1}, 3));
    }

    public int subArrSum(int[] nums, int k) {
        //sum, index
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += sumMap.getOrDefault(sum - k, 0);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}