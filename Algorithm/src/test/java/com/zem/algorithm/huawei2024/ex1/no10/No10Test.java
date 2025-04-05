package com.zem.algorithm.huawei2024.ex1.no10;

import java.util.*;

class No10Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Map<Integer, Integer> idScoreMap = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String[] split = scanner.nextLine().split(" ");
            int id = Integer.parseInt(split[0]);
            int score = Integer.parseInt(split[1]);
            idScoreMap.put(id, score);
        }
        List<Map.Entry<Integer, Integer>> entryList = idScoreMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
        Map<Integer, List<List<Integer>>> result = new TreeMap<>();
        for (int i = 1; i < entryList.size(); i++) {
            Map.Entry<Integer, Integer> pre = entryList.get(i - 1);
            Map.Entry<Integer, Integer> cur = entryList.get(i);
            int diff = cur.getValue() - pre.getValue();
            ArrayList<Integer> pair = new ArrayList<>();
            if (pre.getKey() < cur.getKey()) {
                pair.add(pre.getKey());
                pair.add(cur.getKey());
            } else {
                pair.add(cur.getKey());
                pair.add(pre.getKey());
            }

            List<List<Integer>> pairs = result.getOrDefault(diff, new ArrayList<>());
            pairs.add(pair);
            result.put(diff, pairs);
        }

        List<List<Integer>> lists = result.entrySet().iterator().next().getValue();
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }


    }
}