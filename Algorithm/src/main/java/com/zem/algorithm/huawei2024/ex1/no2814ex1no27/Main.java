package com.zem.algorithm.huawei2024.ex1.no2814ex1no27;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            map.merge(a, 1, Integer::sum);
        }
        int T = sc.nextInt();
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
                .filter(entry -> entry.getValue() >= T)
                .sorted((o1, o2) -> {
                    if (Objects.equals(o1.getValue(), o2.getValue())) {
                        return o1.getKey() - o2.getKey();
                    }
                    return o2.getValue() - o1.getValue();
                }).collect(Collectors.toList());
        if (collect.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(collect.size());
            for (Map.Entry<Integer, Integer> entry : collect) {
                System.out.println(entry.getKey());
            }
        }
    }
}
