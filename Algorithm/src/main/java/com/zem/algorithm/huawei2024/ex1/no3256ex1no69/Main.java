package com.zem.algorithm.huawei2024.ex1.no3256ex1no69;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/13 0013 9:24
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int totalSum = Arrays.stream(arr).sum();
        int n = Integer.parseInt(sc.nextLine());
        
        if (n >= arr.length) {
            System.out.println(totalSum);
            return;
        }
        
        int windowLength = arr.length - n;

        //初始窗口和
        int initalSum = 0;
        for (int i = 0; i < windowLength; i++) {
            initalSum += arr[i];
        }
        int minsum = initalSum;
        int left = 0;
        int right = windowLength;
        while (right < arr.length) {
            int curSum = initalSum - arr[left] + arr[right];
            if (curSum < minsum) {
                minsum = curSum;
            }
            initalSum = curSum;
            left++;
            right++;
        }
        System.out.println(totalSum - minsum);
        
    }
}
