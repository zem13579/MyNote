package com.zem.algorithm.leetcode.learn.part3Sort;

import java.util.*;

public class Lt506 {
    public String[] findRelativeRanks(int[] score) {
        Integer[] copy = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            copy[i] = score[i];
        }
        Arrays.sort(copy,  Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            map.put(copy[i], i + 1);
        }
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int rank = map.get(score[i]) ;
            if (rank == 1) {
                ans[i] = "Gold Medal";
            } else if (rank == 2) {
                ans[i] = "Silver Medal";
            } else if (rank == 3) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = rank + "";
            }
        }

        return ans;
    }
}
