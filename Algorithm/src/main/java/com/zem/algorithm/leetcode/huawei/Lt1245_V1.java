package com.zem.algorithm.leetcode.huawei;

import java.util.*;

public class Lt1245_V1 {
    public static void main(String[] args) {
        Lt1245_V1 lt1245V1 = new Lt1245_V1();
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}};
        System.out.println(lt1245V1.treeDiameter(edges));
    }

    public int treeDiameter(int[][] edges) {
        Map<Integer, Set<Integer>> pointMap = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> orDefault = pointMap.getOrDefault(edge[0], new HashSet<>());
            orDefault.add(edge[1]);
            pointMap.put(edge[0], orDefault);

            orDefault = pointMap.getOrDefault(edge[1], new HashSet<>());
            orDefault.add(edge[0]);
            pointMap.put(edge[1], orDefault);

        }

        Set<Integer> integers = pointMap.keySet();

        int maxLayer = -1;
        Map<Integer, Boolean> visited = new HashMap<>();
        for (Integer integer : integers) {
            visited.put(integer, Boolean.FALSE);
        }

        for (Integer point : integers) {
            visited.put(point, true);
            int layers = this.dfs(pointMap, point, visited);
            if (layers > maxLayer) {
                maxLayer = layers;
            }
            visited.put(point, false);
        }
        return maxLayer - 1;
    }

    private int dfs(Map<Integer, Set<Integer>> pointMap, int point, Map<Integer, Boolean> visited) {
        Set<Integer> integers = pointMap.get(point);
        int max = 1;
        for (Integer next : integers) {
            if (!visited.get(next)) {
                visited.put(next, true);
                int dfs = dfs(pointMap, next, visited) + 1;
                max = Math.max(max, dfs);
                visited.put(next, false);
            }
        }
        return max;
    }
}
