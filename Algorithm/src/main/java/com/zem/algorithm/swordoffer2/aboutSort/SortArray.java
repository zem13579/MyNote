package com.zem.algorithm.swordoffer2.aboutSort;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] ints = sortArray(new int[]{2, 3, 4, 2, 3, 2, 1});
        System.out.println(Arrays.toString(ints));
    }

    public static int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] couts = new int[max - min + 1];
        for (int num : nums) {
            couts[num - min]++;
        }
        int i = 0;
        for (int num = min; num <= max; num++) {
            while (couts[num - min] > 0) {
                nums[i++] = num;
                couts[num - min]--;
            }
        }
        return nums;
    }
}
