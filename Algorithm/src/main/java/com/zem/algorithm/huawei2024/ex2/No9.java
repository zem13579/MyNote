package com.zem.algorithm.huawei2024.ex2;

import java.util.*;

/**
 * 可以进一步优化为查找联通快个数
 */
public class No9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        Graph graph = new Graph();
        while (sc.hasNextLine()) {
            int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //将输入的边的关系转为点的关系 转为一个邻接表数组
            graph.putEdge(array[0], array[1]);
        }
        int minTarget = Integer.MAX_VALUE;
        int minNode = -1;
        for (Integer node : graph.vmap.keySet()) {
            int maxTreeNodes = 0;
            for (Integer root : graph.vmap.get(node)) {
                //找到每个顶点下最大的子树个数 其实就是并查集
                maxTreeNodes = Math.max(graph.getNodes(root, graph.getVisitedMap(node)), maxTreeNodes);
            }
            //总的最小
            if (maxTreeNodes < minTarget) {
                minNode = node;
                minTarget = maxTreeNodes;
            }
        }
        System.out.println(minNode);
    }

    static class Graph {
        Map<Integer, List<Integer>> vmap = new HashMap<>();


        public void putEdge(int x, int y) {
            List<Integer> listx = vmap.getOrDefault(x, new ArrayList<>());
            listx.add(y);
            vmap.put(x, listx);
            List<Integer> listy = vmap.getOrDefault(y, new ArrayList<>());
            listy.add(x);
            vmap.put(y, listy);
        }

        public int getNodes(int node, Map<Integer, Boolean> visitedMap) {

            List<Integer> integers = vmap.get(node);
            int sum = 0;
            for (Integer integer : integers) {
                if (visitedMap.get(integer)) {
                    continue;
                }
                visitedMap.put(integer, true);
                sum += getNodes(integer, visitedMap) + 1;
            }
            return sum;
        }

        public Map<Integer, Boolean> getVisitedMap(int node) {
            Map<Integer, Boolean> visitedMap = new HashMap<>();
            vmap.keySet().forEach(x -> {
                if (x != node) {
                    visitedMap.put(x, false);
                } else {
                    visitedMap.put(x, true);
                }
            });
            return visitedMap;
        }

    }
}
