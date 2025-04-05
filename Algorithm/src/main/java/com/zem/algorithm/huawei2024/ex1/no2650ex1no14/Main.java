package com.zem.algorithm.huawei2024.ex1.no2650ex1no14;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/3 0003 10:01
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String s = sc.nextLine();
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int k = i + 1;
            while (k < arr.length) {
                if (arr[k] > arr[i]) {
                    result[i] = k;
                    break;
                }
                k++;
            }
        }
        Arrays.stream(result).forEach(x -> System.out.print(x + " "));
    }
}
