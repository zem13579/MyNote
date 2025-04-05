package com.zem.algorithm.huawei2024.ex1.no2523ex1no26;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }
        while (pq.size() > 2) {
            solve(pq);
        }
        int max = 0;
        while (!pq.isEmpty()) {
            Integer i = pq.poll();
            max = i > max ? i : max;
        }
        System.out.println(max);
    }

    public static void solve(PriorityQueue<Integer> priorityQueue) {
        int z = priorityQueue.poll();
        int y = priorityQueue.poll();
        int x = priorityQueue.poll();
        if (x == y && y != z) {
            priorityQueue.add(z - y);
        }
        if (x != y && y == z) {
            priorityQueue.add(y - x);
        }
        if (x != y && y != z) {
            int abs = Math.abs((z - y) - (y - x));
            if (abs != 0) {
                priorityQueue.add(abs);
            }

        }
    }
}