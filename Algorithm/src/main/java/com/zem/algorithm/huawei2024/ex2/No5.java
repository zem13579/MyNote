package com.zem.algorithm.huawei2024.ex2;

import java.util.Arrays;
import java.util.Scanner;

public class No5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] weights = new int[num];
        for (int i = 0; i < num; i++) {
            weights[i] = sc.nextInt();
        }
        int totalWeight = Arrays.stream(weights).sum();

        //总质量为奇数则返回-1，无法均分
        if (totalWeight % 2 == 1) {
            System.out.println(-1);
            return;
        }
        //预期质量
        int targetWeight = totalWeight / 2;

        //下标为重量 从1开始 dp[i] 对应该质量下所需最少的雨花石数量
        int[] dp = new int[targetWeight + 1];
        //最坏情况下拿出所有的雨花石
        for (int i = 1; i <= targetWeight; i++) {
            dp[i] = num;
        }

        for (int i = 1; i <= num; i++) {
            //当前雨花石的重量
            int weight = weights[i - 1];
            // todo 遍历每一块雨花石，对于每一块雨花石，从targetWeight开始递减，更新dp数组。如果使用当前雨花石能够减少所需雨花石数量，则更新dp[j]。
            for (int j = targetWeight; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + 1);
            }
        }

        if (dp[targetWeight] == num) {
            System.out.println(-1);
        } else {
            System.out.println(dp[targetWeight]);
        }


    }
}
