package com.zem.algorithm.huawei2024.ex1.no3511noex59;

import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/12 0012 11:12
 */
public class Main {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] visited = new int[m][n];
        System.out.println(dfs(0, 0, m, n, k, visited));
    }
    
    private static int dfs(int i, int j, int m, int n, int k, int[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1 || summon(i) + summon(j) > k) {
            return 0;
        }
        visited[i][j] = 1;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited)
                + dfs(i, j - 1, m, n, k, visited);
    }
    
    private static int summon(int num) {
        int sum = 0;
        while (num > 0) {
            int k = num % 10;
            sum += k;
            num = num / 10;
        }
        return sum;
    }
    
}
