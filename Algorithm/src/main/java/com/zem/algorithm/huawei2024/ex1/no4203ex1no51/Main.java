package com.zem.algorithm.huawei2024.ex1.no4203ex1no51;

import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/9 0009 9:57
 */
public class Main {
    
    private static int count = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int required = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
        int left = 0, right = 0, count = 0, sum = 0;
        
        while (right < num) {
            sum += arr[right];
            while (sum >= required) {
                count += num - right;
                sum -= arr[left];
                left++;
            }
            right++;
        }
        System.out.println(count);
    }
    
}
