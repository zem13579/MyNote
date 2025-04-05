package com.zem.algorithm.huawei2024.ex2.no2527ex2no19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * todo 枚举的方式超时
 */
public class Main {
    static int groupNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] levels = new int[num];
        for (int i = 0; i < num; i++) {
            levels[i] = sc.nextInt();
        }
        int start = 0;
        List<Integer> group = new ArrayList<>();

        dfs(levels, start, group);
        System.out.println(groupNum);
    }

    private static void dfs(int[] levels, int start, List<Integer> group) {
        if (group.size() == 3 ) {
            if ((levels[group.get(0)] < levels[group.get(1)] && levels[group.get(1)] < levels[group.get(2)]) ||
                    (levels[group.get(0)] > levels[group.get(1)] && levels[group.get(1)] > levels[group.get(2)])) {
                groupNum++;
            }
            return;
        }
        for (int i = start; i < levels.length; i++) {
            if ((levels.length - 1 - i + 1) >= 3 - group.size()) {
                group.add(i);
                dfs(levels, i + 1, group);
                group.remove(group.size() - 1);
            }
        }
    }
}
