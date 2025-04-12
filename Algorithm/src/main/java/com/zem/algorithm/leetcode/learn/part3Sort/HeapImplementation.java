package com.zem.algorithm.leetcode.learn.part3Sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapImplementation {
    public static void main(String[] args) {
        // 实现最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(15);
        minHeap.add(5);
        minHeap.add(4);
        minHeap.add(45);

        System.out.print("Min Heap elements: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        // 实现最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(3);
        maxHeap.add(2);
        maxHeap.add(15);
        maxHeap.add(5);
        maxHeap.add(4);
        maxHeap.add(45);

        System.out.print("Max Heap elements: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
    }
}
