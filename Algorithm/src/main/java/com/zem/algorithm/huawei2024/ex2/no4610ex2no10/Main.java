package com.zem.algorithm.huawei2024.ex2.no4610ex2no10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int connections = sc.nextInt();
        int[][] times = new int[connections][3];
        for (int i = 0; i < connections; i++) {
            times[i][0] = sc.nextInt() - 1;
            times[i][1] = sc.nextInt() - 1;
            times[i][2] = sc.nextInt();
        }

        int initial = sc.nextInt() - 1;
        System.out.println(netWorkDelayTime(times, N, initial));
    }

    private static int netWorkDelayTime(int[][] times, int N, int initial) {
        final int Inf = Integer.MAX_VALUE / 2;
        int[] dist = new int[N];
        Arrays.fill(dist, Inf);
        //原电脑的感染时间为0
        dist[initial] = 0;

        for (int i = 0; i < N; i++) {
            for (int[] time : times) {
                int u = time[0], v = time[1], w = time[2];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        int maxWait = 0;
        for (int j : dist) {
            if (j == Inf) {
                return -1;
            }
            maxWait = Math.max(maxWait, j);
        }

        return maxWait;
    }
}

