package com.zem.algorithm.huawei2024.ex1.no2524ex1no49;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<Integer, Map<String, Integer>> recordMap = new HashMap<>();

    public static void main(String[] args) {
        recordMap.put(0, new HashMap<>());
        recordMap.put(1, new HashMap<>());
        recordMap.put(2, new HashMap<>());
        recordMap.put(3, new HashMap<>());
        recordMap.put(4, new HashMap<>());

        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            String s = sc.nextLine();
            String[] split = s.split("/");
            for (int j = 0; j < split.length; j++) {
                Map<String, Integer> levelMap = recordMap.get(j);
                Integer count = levelMap.get(split[j]);
                if (count == null) {
                    count = 1;
                } else {
                    count++;
                }
                levelMap.put(split[j], count);
            }

        }
        String[] split = sc.nextLine().split(" ");
        int level = Integer.parseInt(split[0]);
        String key = split[1];
        Integer i = recordMap.get(level).get(key);
        System.out.println(i ==  null ? 0 : i);
    }


}
