package com.zem.algorithm.huawei2024.ex2.no2522ex2no13;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * todo 题目类似 不完全一致
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        solve(b);
    }

    public static void solve(int num) {
        int sum = 0;
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = num; i >= 1; i--) {
            int start = i;
            while (sum < num) {
                queue.add(start);
                sum += start++;
            }

            if (sum == num) {
                count++;
                StringBuilder sb = new StringBuilder();
                sb.append(num).append("=");
                while (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("+");
                }
                sb.deleteCharAt(sb.length() - 1);
                System.out.println(sb);
            }

            sum = 0;
            queue.clear();
        }
        System.out.println("Result:" + count);
    }
}
