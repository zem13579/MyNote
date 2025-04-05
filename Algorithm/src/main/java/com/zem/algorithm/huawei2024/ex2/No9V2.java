package com.zem.algorithm.huawei2024.ex2;

import java.util.*;

/**
 * 直接使用并查集解决问题
 */
public class No9V2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        int[][] relations = new int[num - 1][2];
        for (int i = 0; i < num - 1; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }

        //最小的最大联通块
        int min_dp = Integer.MAX_VALUE;

        //所在城市
        List<Integer> city = new ArrayList<>();

        //枚举每个城市
        for (int i = 1; i <= num; i++) {
            //初始化并查集 每次都新建一个
            unionFindSet ufs = new unionFindSet(num + 1);
            //将与特殊城市相连的边跳过，不加入集合
            for (int[] relation : relations) {
                int x = relation[0];
                int y = relation[1];
                if (x == i || y == i) {
                    continue;
                }
                ufs.unionSet(x, y);
            }

            Map<Integer, Integer> count = new HashMap<>();
            for (int f : ufs.father) {
                f = ufs.find(f);
                //统计个联通块的大小
                count.merge(f, 1, Integer::sum);
            }

            Integer dp = count.values().stream().max(Integer::compareTo).get();
            if (dp < min_dp) {
                min_dp = dp;
                city.clear();
                city.add(i);
            } else if (dp == min_dp) {
                city.add(i);
            }

        }

        city.forEach(x -> System.out.print(x + " "));

    }

    static class unionFindSet {
        //每个节点的父节点
        private int[] father;

        public unionFindSet(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                //每个父节点都是自己
                father[i] = i;
            }
        }

        public int find(int x) {
            if (father[x] != x) {
                //查找x的祖先节点，同时路径压缩优化
                father[x] = find(father[x]);
            }
            return father[x];
        }

        public void unionSet(int x, int y) {
            int x_Fa = find(x);
            int y_Fa = find(y);
            if (x_Fa != y_Fa) {
                father[y_Fa] = x_Fa;
            }
        }
    }
}
