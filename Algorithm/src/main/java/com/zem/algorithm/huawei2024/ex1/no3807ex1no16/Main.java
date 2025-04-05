package com.zem.algorithm.huawei2024.ex1.no3807ex1no16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(arr).sum();
        List<Integer> list = new ArrayList<>();
        dfs(arr, 5, 0, list, sum);
        System.out.println(minDiff);
    }

    /**
     *  此处适用组合的思路
     * @param arr
     * @param length
     * @param index
     * @param tmp
     * @param sum
     */
    private static void dfs(int[] arr, int length, int index, List<Integer> tmp, int sum) {
        if (tmp.size() == length) {
            int p1 = tmp.stream().reduce(0, Integer::sum);
            int diff = Math.abs(sum - p1 * 2);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        for (int i = index; i < arr.length; i++) {
            tmp.add(arr[i]);
            dfs(arr, length, i + 1, tmp, sum);
            tmp.remove(tmp.size() - 1);
        }
    }
}

