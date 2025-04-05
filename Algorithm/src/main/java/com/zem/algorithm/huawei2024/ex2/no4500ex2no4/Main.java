package com.zem.algorithm.huawei2024.ex2.no4500ex2no4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        unionFindSet unionSet = new unionFindSet(N);

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int p = sc.nextInt();
            edges.add(new Edge(x, y, z, p));
            if (p == 1) {
                unionSet.union(x, y);
            }
        }

        //根据成本从小到大排序
        edges.sort(Comparator.comparingInt(x -> x.cost));

        int totalCost = 0;

        for (Edge edge : edges) {
            //如果两个端点不在集合中，则将边添加到集合（最小生成树）
            if (unionSet.find(edge.u) != unionSet.find(edge.v)) {
                totalCost += edge.cost;
                unionSet.union(edge.u, edge.v);
            }
        }

        //检查基站是否在同一个集合中
        for (int i = 2; i <= N; i++) {
            if(unionSet.find(i) != unionSet.find(1)){
                //如果有基站不在集合中，则输出-1 并结束程序
                System.out.println(-1);
                return;
            }
        }
        System.out.println(totalCost);
    }

    static class unionFindSet {

        int[] parent;

        public unionFindSet(int N) {
            this.parent = new int[N + 1];
            for (int i = 1; i < N; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                parent[rootx] = rooty;
            }
        }

    }

    static class Edge {
        int u, v, cost, pre;

        public Edge(int u, int v, int cost, int pre) {
            this.u = u;
            this.v = v;
            this.cost = cost;
            this.pre = pre;
        }
    }
}
