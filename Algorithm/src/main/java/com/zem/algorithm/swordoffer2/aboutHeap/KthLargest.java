package com.zem.algorithm.swordoffer2.aboutHeap;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {

    }

    static class kthLargest {
        private PriorityQueue<Integer> minHeap;
        private int size;

        public kthLargest(int k, int[] nums) {
            minHeap = new PriorityQueue<>();
            size = k;
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            if (minHeap.size() < size) {
                minHeap.add(val);
            } else if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.add(val);
            }
            return minHeap.peek();
        }
    }
}
