package com.zem.algorithm.huawei2024.ex2.no3806ex2no22;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static int maxRound = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        String[] colors = sc.nextLine().split(" ");
        boolean[] visited = new boolean[nums.length];
        int currentRound = 1;
        for (int index = 0; index < nums.length; index++) {
            visited = new boolean[nums.length];
            visited[index]=true;
            dfs(nums, colors, visited, currentRound, index);
        }
        System.out.println(maxRound);

    }

    private static void dfs(String[] nums, String[] colors, boolean[] visited, int currentRound, int index) {
        List<Integer> nextColor = hasNextColor(index, colors, visited);
        List<Integer> nextNum = hasNextNum(index, nums, visited);
        if (nextColor.isEmpty() && nextNum.isEmpty()) {
            if (currentRound > maxRound) {
                maxRound = currentRound;
            }
            return;
        }
        for (Integer i : nextColor) {
            visited[i] = true;
            dfs(nums, colors, visited, currentRound + 1, i);
            visited[i] = false;
        }
        for (Integer i : nextNum) {
            visited[i] = true;
            dfs(nums, colors, visited, currentRound + 1, i);
            visited[i] = false;
        }

    }

    public static List<Integer> hasNextNum(int index, String[] nums, boolean[] visited) {
        List<Integer> result = new ArrayList<>();
        String curNum = nums[index];
        for (int i = 0; i < nums.length; i++) {
            if (Objects.equals(nums[i], curNum) && !visited[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> hasNextColor(int index, String[] colors, boolean[] visited) {
        List<Integer> result = new ArrayList<>();
        String curColor = colors[index];
        for (int i = 0; i < colors.length; i++) {
            if (Objects.equals(colors[i], curColor) && !visited[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
