package com.zem.algorithm.huawei2024.ex1;

import java.util.*;

/**
 * todo 有点怪,感觉没必要这么复杂
 * todo 见test,中更简单的例子
 */
public class No37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int taskNum = sc.nextInt();
        int time = sc.nextInt();
        List<List<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < taskNum; i++) {
            int deadline = sc.nextInt();
            int score = sc.nextInt();
            tasks.add(Arrays.asList(deadline, score));
        }
        tasks.sort(Comparator.comparingInt(x -> x.get(0)));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (List<Integer> task : tasks) {
            int deadline = task.get(0);
            int score = task.get(1);
            if (queue.size() < deadline) {
                queue.add(score);
            } else if (!queue.isEmpty() && queue.peek() < score) {
                queue.poll();
                queue.add(score);
            }
            if (queue.size() > time) {
                queue.poll();
            }

        }

        int total = 0;
        while (!queue.isEmpty()) {
            total += queue.poll();
        }
        System.out.println(total);
    }
}
