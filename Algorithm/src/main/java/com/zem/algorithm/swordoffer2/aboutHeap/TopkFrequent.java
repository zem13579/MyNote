package com.zem.algorithm.swordoffer2.aboutHeap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 面试题60：出现频率最高的k个数字
 */
public class TopkFrequent {
    public static void main(String[] args) {
        List<Integer> integers = topKFrequent(new int[]{1, 2, 2, 1, 3, 1}, 2);
        System.out.println(integers);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        //整理出出现频率
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );
        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (minHeap.peek().getValue() < entry.getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        return minHeap.stream().map(Map.Entry::getKey).collect(Collectors.toList());

    }
}
