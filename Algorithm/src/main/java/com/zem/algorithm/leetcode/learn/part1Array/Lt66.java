package com.zem.algorithm.leetcode.learn.part1Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2025/3/17 0017 15:56
 */
public class Lt66 {
    
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        
        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
    
    public int[] plusOne1(int[] digits) {
        int addFlag = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = i == digits.length - 1 ? digits[i] + 1 + addFlag : digits[i] + addFlag;
            addFlag = tmp > 9 ? 1 : 0;
            digits[i] = tmp > 9 ? 0 : tmp;
        }
        if (addFlag == 1) {
            int[] ans = new int[digits.length + 1];
            System.arraycopy(digits, 0, ans, 1, digits.length);
            ans[0] = 1;
            digits = ans;
        }
        return digits;
    }
    
    public static void main(String[] args) {
        int[] ints = {9, 9};
        Lt66 lt66 = new Lt66();
        int[] ints1 = lt66.plusOne(ints);
        System.out.println(Arrays.toString(ints1));
    }
}
