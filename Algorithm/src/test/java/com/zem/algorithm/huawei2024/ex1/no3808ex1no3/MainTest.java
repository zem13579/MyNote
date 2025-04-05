package com.zem.algorithm.huawei2024.ex1.no3808ex1no3;

import java.util.*;

/**
 * todo 部分没有通过？感觉和原版差距不大
 */
class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.split(" ");
        char[] charArray = split[0].toCharArray();
        int number = Integer.parseInt(split[1]);

        Set<String> res = new HashSet<>();
        List<Character> tmp = new ArrayList<>();
        boolean[] visited = new boolean[charArray.length];
        backTrace(number, charArray, res, tmp, visited);
        System.out.println(res.size());
    }

    private static void backTrace(int length, char[] source, Set<String> res, List<Character> tmp, boolean[] visited) {
        if (tmp.size() == length) {
            StringBuilder sb = new StringBuilder();
            for (Character c : tmp) {
                sb.append(c);
            }
            res.add(sb.toString());
        }
        for (int i = 0; i < source.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (tmp.size() != 0 && tmp.get(tmp.size() - 1) == source[i]) {
                continue;
            }

            visited[i] = true;
            tmp.add(source[i]);
            backTrace(length, source, res, tmp, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}