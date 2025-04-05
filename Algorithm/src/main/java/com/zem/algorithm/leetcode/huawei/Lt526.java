package com.zem.algorithm.leetcode.huawei;

import java.util.Arrays;

public class Lt526 {
    public static void main(String[] args) {
        Lt526 lt526 = new Lt526();
        System.out.println(lt526.countArrangement(3));
    }

    int count = 0;

    public int countArrangement(int n) {
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        boolean[] hasUsed = new boolean[n + 1];
        Integer[] answer = new Integer[n + 1];
        traceBack(n, 1, nums, hasUsed, answer);
        return count;
    }

    private void traceBack(int n, int index, int[] numbs, boolean[] hasUsed, Integer[] answer) {
        if (index == n + 1) {
            count++;
            System.out.println(Arrays.toString(answer));
            return;
        }
        for (int j = 1; j < numbs.length; j++) {
            if (!hasUsed[j] && (numbs[j] % index == 0 || index % numbs[j] == 0)) {
                hasUsed[j] = true;
                answer[index] = numbs[j];
                traceBack(n, index + 1, numbs, hasUsed, answer);
                answer[index] = null;
                hasUsed[j] = false;
            }
        }
    }
}
