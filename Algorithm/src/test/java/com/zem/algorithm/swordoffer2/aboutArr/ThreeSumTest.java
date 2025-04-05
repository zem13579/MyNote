package com.zem.algorithm.swordoffer2.aboutArr;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class ThreeSumTest {

    @Test
    public void test(){
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i++;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    int nowValue = nums[j];
                    while (j < k && nowValue == nums[j]) {
                        j++;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    ++j;
                }
            }
            int thisi = nums[i];
            while (i<nums.length&& nums[i] == thisi){
                i++;
            }
        }
        return result;
    }

}