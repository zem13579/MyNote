package com.zem.algorithm.leetcode.huawei;

import java.util.*;

public class Lt1245_V2 {
    public static void main(String[] args) {
        Lt1245_V2 lt1245V1 = new Lt1245_V2();
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}};
        int[][] edges = {{0, 1}, {0, 2}};
        System.out.println(lt1245V1.treeDiameter(edges));
    }


    //两次bfs
    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            graph.computeIfAbsent(i, k -> new ArrayList<>());
            graph.computeIfAbsent(j, k -> new ArrayList<>());
            graph.get(i).add(j);
            graph.get(j).add(i);
        }

        int firstNode = edges[0][0];

        int[] ans = this.bfs(graph, firstNode);
        int[] ans2 = this.bfs(graph, ans[0]);
        return ans2[1];
    }

    private int[] bfs(Map<Integer, List<Integer>> graph, int firstNode) {
        boolean[] visited = new boolean[graph.keySet().size()];

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(firstNode);
        int layerCounter = -1;
        int lastNode = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                visited[curNode] = true;
                lastNode = curNode;
                List<Integer> nextNodes = graph.get(lastNode);
                for (Integer nextNode : nextNodes) {
                    if (!visited[nextNode]) {
                        queue.offer(nextNode);
                    }
                }
            }
            layerCounter++;
        }

        return new int[]{lastNode, layerCounter};
    }

}
