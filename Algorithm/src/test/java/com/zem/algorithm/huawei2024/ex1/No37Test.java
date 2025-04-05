package com.zem.algorithm.huawei2024.ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 4
 * 3
 * 1 2
 * 2 3
 * 3 4
 * 3 5
 */
class No37Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int taskNum = Integer.parseInt(sc.nextLine());
        int deadLine = Integer.parseInt(sc.nextLine());
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < taskNum; i++) {
            int slv = sc.nextInt();
            int value = sc.nextInt();
            tasks.add(new Task(slv, value));
        }

        AtomicInteger totalValue = new AtomicInteger();
        for (int i = deadLine; i > 0; i--) {
            int finalI = i;
            tasks.stream().filter(x -> x.getSlv() >= finalI)
                    .max(Comparator.comparing(Task::getValue))
                    .ifPresent(task1 -> {
                        tasks.remove(task1);
                        totalValue.addAndGet(task1.getValue());
                    });
        }
        System.out.println(totalValue.get());

    }

    static class Task {
        int slv;
        int value;

        public Task(int slv, int value) {
            this.slv = slv;
            this.value = value;
        }

        public int getSlv() {
            return slv;
        }

        public void setSlv(int slv) {
            this.slv = slv;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}