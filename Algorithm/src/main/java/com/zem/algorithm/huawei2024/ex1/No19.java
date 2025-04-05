package com.zem.algorithm.huawei2024.ex1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/4 0004 9:16
 */
public class No19 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = 1;
        int max = Arrays.stream(array).max().getAsInt();
        
        if (array.length > 8) {
            System.out.println(-1);
        }
        while (min < max) {
            int k = (min + max) / 2;
            if (canFinish(array, k)) {
                max = k;
            } else {
                min = k + 1;
            }
        }
        System.out.println(min);
    }
    
    private static boolean canFinish(int[] array, int k) {
        int sum = 0;
        for (int i : array) {
            sum += (int) Math.ceil(i * 1.0 / k);
        }
        return sum <= 8;
    }
}
