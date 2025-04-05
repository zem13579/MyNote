package com.zem.algorithm.huawei2024.ex1.no2819ex1no40;

import java.util.*;

public class Main {

    //todo 修复map版本
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wordNum = sc.nextInt();
        List<Map<Character, Integer>> words = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < wordNum; i++) {
            String s = sc.nextLine();
            Map<Character, Integer> tmp = new HashMap<>();
            for (char c : s.toCharArray()) {
                tmp.merge(c, 1, Integer::sum);
            }
            words.add(tmp);
        }
        Map<Character, Integer> learned = new HashMap<>();
        String learnedChars = sc.nextLine();
        for (char c : learnedChars.toCharArray()) {
            learned.merge(c, 1, Integer::sum);
        }
        int all = learned.get('?');
        int result = 0;
        for (Map<Character, Integer> word : words) {
            int miss = 0;
            for (Map.Entry<Character, Integer> entry : word.entrySet()) {
                Character key = entry.getKey();
                Integer num1 = learned.getOrDefault(key, 0);
                Integer num2 = entry.getValue();
                if (num1 < num2) {
                    miss += num2 - num1;

                }
            }
            if (miss <= all) {
                result++;
            }
        }
        System.out.println(result);
    }
}