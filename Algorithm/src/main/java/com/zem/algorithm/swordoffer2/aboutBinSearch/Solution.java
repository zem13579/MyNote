package com.zem.algorithm.swordoffer2.aboutBinSearch;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    private int[] sums;
    private int total;

    public Solution(int[] w) {
        sums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }

    public int pickIndex() {
        int p = ThreadLocalRandom.current().nextInt(total);
        int left = 0;
        int right = sums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sums[mid] > p) {
                if (mid == 0 || (sums[mid - 1] <= p)) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        Solution solution = new Solution(ints);
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }
}
