package com.zem.algorithm.swordoffer2.aboutArr;


/**
 * 和大于或等于k的最短子数组
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int[] arr = new int[]{5, 1, 4, 3};
        System.out.println(minSubArrayLen.minSubArrayLen2(arr, 7));
    }

    public int minSubArrayLen(int[] arr, int target) {
        int i = 0;
        int j = i + 1;
        int minLen = 0;
        while (i < j) {
            int tempsum = 0;
            for (int k = i; k <= j; k++) {
                tempsum += arr[k];
            }
            if (tempsum < target) {
                j++;
            } else {
                if (j - i > minLen) {
                    minLen = j - i;
                }
                i++;
            }
        }
        return minLen;
    }

    public int minSubArrayLen2(int[] arr, int target) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (left <= right && sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
