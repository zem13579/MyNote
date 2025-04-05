package com.zem.algorithm.swordoffer2.aboutBinSearch;

public class SingleNonDuplicate {

    public static void main(String[] args) {
        SingleNonDuplicate nonDuplicate = new SingleNonDuplicate();
        System.out.println(nonDuplicate.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}));
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid * 2;
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) {
                if (mid == 0 || nums[i - 2] == nums[i - 1]) {
                    return nums[i];
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //在最后一个的情况
        return nums[nums.length - 1];

    }
}
