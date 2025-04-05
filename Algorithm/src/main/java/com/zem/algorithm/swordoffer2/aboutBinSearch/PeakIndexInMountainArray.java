package com.zem.algorithm.swordoffer2.aboutBinSearch;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        PeakIndexInMountainArray obj = new PeakIndexInMountainArray();
        System.out.println(obj.peakIndexInMountainArray(new int[]{1, 2, 3, 2}));
    }

    public int peakIndexInMountainArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            }
            if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
