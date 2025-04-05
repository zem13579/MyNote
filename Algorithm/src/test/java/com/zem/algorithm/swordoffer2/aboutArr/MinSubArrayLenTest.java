package com.zem.algorithm.swordoffer2.aboutArr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class MinSubArrayLenTest {

    @Test
    public void test(){
        System.out.println(minSubArrayLen(7, new int[]{5, 1, 4, 3}));
    }

    public int minSubArrayLen(int k, int[] nums) {
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        List<Integer> minArr = new ArrayList<>();
        while (left <= right && right < nums.length) {
            sum += nums[right];
            while (sum >= k) {
                int length = right - left + 1;
                if (length < minLength) {
                    minLength = length;
                    int[] ints = Arrays.copyOfRange(nums, left, right + 1);
                    minArr.clear();
                    minArr.addAll(Arrays.stream(ints).boxed()
                            .collect(Collectors.toList()));
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        System.out.println(minArr);
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}