package com.zem.algorithm.swordoffer2.aboutSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 面试题74：合并区间
 */
public class MergeIntervals {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] temp = {intervals[i][0], intervals[i][1]};
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[j][1]);
                j++;
            }
            merged.add(temp);
            i = j;
        }
        int[][] result = new int[merged.size()][];
        return merged.toArray(result);
    }
}
