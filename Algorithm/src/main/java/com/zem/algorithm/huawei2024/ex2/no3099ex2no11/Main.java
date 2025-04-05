package com.zem.algorithm.huawei2024.ex2.no3099ex2no11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        sc.close();

        //0-value 1-cutTime 2-lenght1
        int[][] dp = new int[length + 1][3];
        for (int i = 1; i <= length; i++) {
            int max = i;
            int cutTime = 0;
            dp[i][0] = i;
            dp[i][1] = 0;
            dp[i][2] = i;
            for (int j = 1, k = i - 1; j <= k; j++, k--) {
                int value = dp[j][0] * dp[k][0];
                if (value > max) {
                    max = value;
                    dp[i][0] = max;
                    dp[i][1] = dp[j][1] + dp[k][1] + 1;
                    dp[i][2] = j;
                } else if (value == max) {
                    if (dp[i][1] > dp[j][1] + dp[k][1] + 1) {
                        dp[i][1] = dp[j][1] + dp[k][1] + 1;
                        dp[i][2] = j;
                    }
                }
            }
        }

        List<Integer> results = new ArrayList<>();
        while (length > 0) {
            results.add(dp[length][2]);
            length -= dp[length][2];
        }

        Collections.sort(results);

        results.forEach(x -> System.out.print(x + " "));

    }
}
