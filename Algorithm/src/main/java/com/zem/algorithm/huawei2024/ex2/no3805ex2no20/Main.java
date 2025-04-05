package com.zem.algorithm.huawei2024.ex2.no3805ex2no20;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] split = sc.nextLine().split(" ");

        List<Integer> tmpgroup = new ArrayList<>();

        int start = 0;
        boolean[] visited = new boolean[split.length];
        solve(split, tmpgroup, visited);

        Set<String> realResult = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (List<Integer> integers : result) {
            for (Integer i : integers) {
                sb.append(split[i]);
            }
            realResult.add(sb.toString());
            sb.delete(0, sb.length());
        }
        List<String> collect = realResult.stream().sorted().collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    private static void solve(String[] split, List<Integer> tmpgroup, boolean[] visited) {
        if (tmpgroup.size() == split.length) {
            result.add(new ArrayList<>(tmpgroup));
            return;
        }
        for (int i = 0; i < split.length; i++) {
            if (visited[i]) {
                continue;
            }
            tmpgroup.add(i);
            visited[i] = true;
            solve(split, tmpgroup, visited);
            tmpgroup.remove(tmpgroup.size() - 1);
            visited[i] = false;
        }
    }
}
