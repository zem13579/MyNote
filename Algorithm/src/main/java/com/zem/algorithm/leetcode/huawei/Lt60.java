package com.zem.algorithm.leetcode.huawei;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Lt60 {


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }
        return counter.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).mapToInt(Map.Entry::getKey).toArray();


    }
}
