package com.zem.algorithm.swordoffer2.aboutSort;


import static com.zem.algorithm.swordoffer2.aboutSort.QuickSort.partition;

/**
 * 面试题76：数组中第k大的数字
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int kthLargest = new FindKthLargest().findKthLargest(new int[]{4, 1, 5, 3, 6, 2, 7, 8}, 3);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != target) {
            if (index > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }
}
