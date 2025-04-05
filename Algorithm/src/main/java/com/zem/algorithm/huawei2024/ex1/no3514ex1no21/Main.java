package com.zem.algorithm.huawei2024.ex1.no3514ex1no21;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/4 0004 10:04
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] tmp = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < n - 1; i++) {
            int[] pair = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            tmp[pair[0] - 1] += arr[pair[1] - 1];
        }
        System.out.println(Arrays.stream(tmp).max().getAsInt());
    }
}
