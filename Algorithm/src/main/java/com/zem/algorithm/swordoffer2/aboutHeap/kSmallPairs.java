package com.zem.algorithm.swordoffer2.aboutHeap;

import java.util.*;
import java.util.stream.Collectors;

public class kSmallPairs {
    public static void main(String[] args) {
        int[] nums1 = {1, 5, 13, 21};
        int[] nums2 = {2, 4, 9, 15};
        System.out.println(kSmallPairs(nums1, nums2, 3));
        System.out.println(kSmallPairs2(nums1, nums2, 3));
    }

    public static List<List<Integer>> kSmallPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] + p2[1] - p1[0] - p1[1]);
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(new int[]{nums1[i], nums2[j]});
                } else {
                    int[] peek = maxHeap.peek();
                    if (peek[0] + peek[1] > nums1[i] + nums2[j]) {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        return maxHeap.stream()
                .map(x -> Arrays.asList(x[0], x[1])).sorted((p1, p2) -> p1.get(0) + p1.get(1) - p2.get(0) - p2.get(1))
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> kSmallPairs2(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> nums1[p1[0]] + nums2[p1[1]] - nums1[p2[0]] - nums2[p2[1]]);
        if (nums2.length > 0) {
            for (int i = 0; i < Math.min(k, nums1.length); i++) {
                minHeap.offer(new int[]{i, 0});
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] ids = minHeap.poll();
            result.add(new ArrayList<>(Arrays.asList(nums1[ids[0]], nums2[ids[1]])));
            if (ids[1] < nums2.length - 1) {
                minHeap.offer(new int[]{ids[0], ids[1] + 1});
            }
        }
        return result;
    }
}
