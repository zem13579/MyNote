package com.zem.algorithm.swordoffer2.aboutArr;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = new int[]{1, 2, 4, 6, 10};
        int[] ints = twoSum.twoSum(arr, 8);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{i, j};
    }
}
