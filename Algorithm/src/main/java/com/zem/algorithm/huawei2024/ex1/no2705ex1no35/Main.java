package com.zem.algorithm.huawei2024.ex1.no2705ex1no35;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();

        arr = Arrays.stream(arr).distinct().sorted().toArray();

        if (2 * n > arr.length) {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        for (int i = 0, j = arr.length - 1; i < n; i++, j--) {
            sum += arr[i] + arr[j];
        }
        System.out.println(sum);
    }
}
