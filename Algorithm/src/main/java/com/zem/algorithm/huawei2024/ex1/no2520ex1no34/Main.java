package com.zem.algorithm.huawei2024.ex1.no2520ex1no34;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxTasks = sc.nextInt();
        int taskArrLen = sc.nextInt();
        int[] taskArr = new int[taskArrLen];
        for (int i = 0; i < taskArr.length; i++) {
            taskArr[i] = sc.nextInt();
        }
        int curTasks = 0;
        int time = 0;
        int index = 0;
        while (curTasks != 0 || index != taskArr.length) {
            if (index < taskArrLen) {
                curTasks += taskArr[index];
                index++;
            }
            curTasks -= maxTasks;
            if (curTasks < 0) {
                curTasks = 0;
            }
            time++;
        }
        System.out.println(time);
    }
}
