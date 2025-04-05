package com.zem.algorithm.huawei2024.ex1.no3117ex1no50;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/9 0009 9:19
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        int minRequire = sc.nextInt();
        Arrays.sort(arr);
        int count = 0;
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[j] >= minRequire) {
                count++;
                j--;
            } else if (arr[i] + arr[j] >= minRequire) {
                count++;
                i++;
                j--;
            } else {
                i++;
            }
        }
        if (i == j && arr[j] >= minRequire) {
            count++;
        }
        System.out.println(count);
        
    }
}
