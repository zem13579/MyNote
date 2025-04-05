package com.zem.algorithm.huawei2024.ex1.no3497ex1no68;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] ganrans = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> ganranSet = new HashSet<>();
        Set<Integer> needCheck = new HashSet<>();
        for (int ganran : ganrans) {
            queue.add(ganran);
            ganranSet.add(ganran);
        }
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int i = 0; i < arr.length; i++) {
                int k = arr[i][cur];
                if (k == 1) {
                    //有接触
                    if (!ganranSet.contains(i) && !needCheck.contains(i)) {
                        //感染队列和需要检测检测人力都没有他，则加入检测队列
                        queue.add(i);
                        needCheck.add(i);
                    }
                }
            }
        }
        System.out.println(needCheck.size());

    }
}
