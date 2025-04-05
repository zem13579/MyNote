package com.zem.algorithm.huawei2024.ex1.no2532ex1no2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int count = 0;
        int[] tmp = new int[arr.length + 2];
        tmp[0] = -1;
        tmp[tmp.length - 1] = -1;
        System.arraycopy(arr, 0, tmp, 1, arr.length);
        for (int i = 1; i < tmp.length - 1; i++) {
            if (tmp[i - 1] < tmp[i] && tmp[i] > tmp[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
