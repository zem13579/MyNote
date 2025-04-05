package com.zem.algorithm.huawei2024.ex2.no3396ex2no6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] costs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] days = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(miniCost(costs, days));

    }

    private static int miniCost(int[] costs, int[] days) {
        int maxDay = Arrays.stream(days).max().getAsInt();
        boolean[] travelDays = new boolean[maxDay + 1];
        for (int day : days) {
            travelDays[day] = true;
        }

        int[] dp = new int[maxDay + 1];
        for (int i = 1; i <= maxDay; i++) {
            //当天参观吗，不参数则跳过，为默认值0
            if (!travelDays[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            int cost1 = dp[Math.max(0, i - 1)] + costs[0];
            int cost3 = dp[Math.max(0, i - 3)] + costs[1];
            int cost7 = dp[Math.max(0, i - 7)] + costs[2];
            int cost30 = dp[Math.max(0, i - 30)] + costs[3];

            dp[i] = Math.min(cost1,Math.min(cost3,Math.min(cost7,cost30)));
        }

        return dp[maxDay];

    }
}
