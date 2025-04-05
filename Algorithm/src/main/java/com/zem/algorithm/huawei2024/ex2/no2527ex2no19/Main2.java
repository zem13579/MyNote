package com.zem.algorithm.huawei2024.ex2.no2527ex2no19;

import java.util.Scanner;

/**
 * todo 枚举的方式超时
 */
public class Main2 {
    static int groupNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] levels = new int[num];
        for (int i = 0; i < num; i++) {
            levels[i] = sc.nextInt();
        }

        long tems = countTeams(num, levels);
        System.out.println(tems);
    }

    private static long countTeams(int num, int[] levels) {
        long ans = 0;
        int[] smallerLeft = new int[num];
        int[] granterLeft = new int[num];
        int[] smallerRight = new int[num];
        int[] granterRight = new int[num];

        for (int i = 1; i < num; i++) {
            for (int j = 0; j < i; j++) {
                if (levels[j] < levels[i]) {
                    smallerLeft[i]++;
                } else if (levels[j] > levels[i]) {
                    granterLeft[i]++;
                }
            }
        }

        for (int i = num - 2; i >= 0; i--) {
            for (int j = num - 1; j > i; j--) {
                if (levels[j] < levels[i]) {
                    smallerRight[i]++;
                } else if (levels[j] > levels[i]) {
                    granterRight[i]++;
                }
            }
        }

        for (int i = 0; i < num; i++) {
            ans += (long) smallerLeft[i] * granterRight[i] + (long) granterLeft[i] * smallerRight[i];
        }


        return ans;
    }


}
