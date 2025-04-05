package com.zem.algorithm.huawei2024.ex1.no2556ex1no22;

import java.util.*;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/4 0004 15:10
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] weight = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            int score = 0;
            for (int j = 1; j < split.length; j++) {
                score += weight[j - 1] * Integer.parseInt(split[j]);
            }
            map.put(split[0], score);
        }
        List<Map.Entry<String, Integer>> collect = map.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue() - o2.getValue() != 0) {
                return o2.getValue() - o1.getValue();
            } else {
                return o1.getKey().toLowerCase().compareTo(o2.getKey().toLowerCase());
            }
        }).toList();
        for (Map.Entry<String, Integer> entry : collect) {
            System.out.println(entry.getKey());
        }
    }
}
