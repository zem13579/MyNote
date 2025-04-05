package com.zem.algorithm.huawei2024.ex1.no15;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/3 0003 10:20
 */
public class No15 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arrStr = sc.nextLine();
        int[] arr = Arrays.stream(arrStr.split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = sc.nextInt();
        if (arr.length > h) {
            System.out.println(0);
            return;
        }
        int min = 1;
        int max = Arrays.stream(arr).max().getAsInt();
        while (min < max) {
            int k = (min + max) / 2;
            int canfinish = canfinish(arr, k, h);
            if (canfinish >= 0) {
                max = k;
            } else {
                min = k + 1;
            }
        }
        System.out.println(min);
    }
    
    private static int canfinish(int[] arr, int k, int h) {
        int total = 0;
        for (int i : arr) {
            total += (int) Math.ceil(i * 1.0 / k);
        }
        return h - total;
    }
}
