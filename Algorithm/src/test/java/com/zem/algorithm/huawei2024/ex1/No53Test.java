package com.zem.algorithm.huawei2024.ex1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class No53Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = Integer.parseInt(sc.nextLine());
        sc.close();

        Map<Character, Integer> countMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int count = 1;
            while (i + 1 < charArray.length && charArray[i] == charArray[i + 1]) {
                count++;
                i++;
            }
            countMap.merge(c, count, Math::max);
        }
        Map.Entry<Character, Integer> entry = null;

        try {
            entry = countMap.entrySet().stream()
                    .sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
                    .collect(Collectors.toList()).get(k - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(-1);
            return;
        }

        System.out.println(entry.getValue());
    }
}