package com.zem.algorithm.swordoffer2.aboutArr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 数组中和为0的3个数字
 */
public class ThreeSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if ((nums.length >= 3)) {
            //排序
            Arrays.sort(nums);
            int i = 0;
            while (i < nums.length - 2) {
                twoSum(nums, i, result);
                int temp = nums[i];
                //跳过重复的组合
                while (i < nums.length && nums[i] == temp) {
                    ++i;
                }
            }

        }
        return result;
    }

    private void twoSum(int[] nums, int i, LinkedList<List<Integer>> result) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[j] + nums[k] + nums[i] == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                int temp = nums[j];
                //跳过重复的组合
                while (j < k && nums[j] == temp) {
                    ++j;
                }
            } else if (nums[j] + nums[k] + nums[i] < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
}
