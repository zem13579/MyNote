package com.zem.algorithm.swordoffer;

/**
 * @Author zem
 * @Date 2023/10/24
 * @Describe
 */
public class Code31 {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        Code31 code31 = new Code31();
        System.out.println(code31.findGreatestSumOfSubArray(arr));
    }

    public Integer findGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int cur_sum = 0;
        int greatest_sum = Integer.MIN_VALUE;
        for (int i : arr) {
            if (cur_sum <= 0) {
                cur_sum = i;
            } else {
                cur_sum += i;
            }
            if (cur_sum > greatest_sum) {
                greatest_sum = cur_sum;
            }
        }
        return greatest_sum;
    }


}
