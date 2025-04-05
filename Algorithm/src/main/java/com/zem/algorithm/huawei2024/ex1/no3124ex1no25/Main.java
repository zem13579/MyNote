package com.zem.algorithm.huawei2024.ex1.no3124ex1no25;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                Integer tmp = sc.nextInt();
                arr[i][j] = tmp;
                if (tmp == 0) {
                    continue;
                }
                List<List<Integer>> list = map.getOrDefault(tmp, new ArrayList<>());
                list.add(Arrays.asList(i, j));
                map.put(tmp, list);
            }
        }

        List<Integer> areas = new ArrayList<>();
        areas.add(1);
        map.entrySet().stream().filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> {
                    List<List<Integer>> value = entry.getValue();
                    int maxM = 0, minM = Integer.MAX_VALUE;
                    int maxN = 0, minN = Integer.MAX_VALUE;
                    for (List<Integer> integers : value) {
                        int a = integers.get(0);
                        int b = integers.get(1);
                        maxM = Math.max(maxM, a);
                        minM = Math.min(minM, a);
                        maxN = Math.max(maxN, b);
                        minN = Math.min(minN, b);
                    }
                    areas.add((maxM - minM + 1) * (maxN - minN + 1));
                });

        System.out.println(Collections.max(areas));
    }
}
