package com.zem.algorithm.huawei2024.ex2.no2527ex2no19;

import java.util.Scanner;

/**
 * todo 枚举的方式超时
 * 4
 * 1 2 3 4
 *
 */
public class Main3 {
    static int groupNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] levels = new int[num];
        for (int i = 0; i < num; i++) {
            levels[i] = sc.nextInt();
        }

        for (int i = 0; i < levels.length - 2; i++) {
            for (int j = i + 1; j < levels.length - 1; j++) {
                for (int k = j + 1; k < levels.length; k++) {
                    if ((levels[i] < levels[j] && levels[j] < levels[k]) || (levels[i] > levels[j] && levels[j] > levels[k])) {
                        groupNum++;
                    }
                }
            }
        }

        System.out.println(groupNum);
    }
}
