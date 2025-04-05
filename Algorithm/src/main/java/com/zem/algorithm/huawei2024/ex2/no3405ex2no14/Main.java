package com.zem.algorithm.huawei2024.ex2.no3405ex2no14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(distribute(m, n, n, 0, new int[m]));
    }

    /**
     * @param m          员工数量
     * @param remaining  剩余月饼数
     * @param maxAllowed
     * @param index
     * @param distribute
     * @return
     */
    private static int distribute(int m, int remaining, int maxAllowed, int index, int[] distribute) {
        if (index == m - 1) {
            if (remaining <= maxAllowed && (index == 0 || Math.abs(distribute[index - 1] - remaining) <= 3)) {
                return 1;
            }
            return 0;
        }

        int ways = 0;
        int start = (index == 0 ? 1 : distribute[index - 1] - 3);
        int end = Math.min(remaining - (m - index - 1), maxAllowed);

        for (int i = start; i <= end; i++) {
            distribute[index] = i;
            if (index == 0 || Math.abs(distribute[index - 1] - i) <= 3) {
                ways += distribute(m, remaining - i, i, index + 1, distribute);
            }
        }
        return ways;
    }
}
