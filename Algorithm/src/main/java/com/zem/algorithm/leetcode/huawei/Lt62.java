package com.zem.algorithm.leetcode.huawei;

public class Lt62 {
    public static void main(String[] args) {
        Lt62 lt62 = new Lt62();
        System.out.println(lt62.uniquePaths(3, 7));
    }


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 < 0 || j - 1 < 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
