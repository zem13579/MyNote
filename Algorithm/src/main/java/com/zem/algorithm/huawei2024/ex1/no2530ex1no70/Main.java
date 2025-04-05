package com.zem.algorithm.huawei2024.ex1.no2530ex1no70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/13 0013 10:24
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] targetPoint = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> points = new ArrayList<>();
        int m = arr[0];
        int n = arr[1];
        for (int i = 2; i < arr.length; i += 2) {
            int value = arr[i];
            int number = arr[i + 1];
            points.add(Arrays.asList(value, number));
        }
        
        //
        int offset = targetPoint[0] * n + targetPoint[1] + 1;
        int sumOffset = 0;
        for (List<Integer> point : points) {
            sumOffset += point.get(1);
            if (sumOffset >= offset) {
                System.out.println(point.get(0));
                return;
            }
        }
        
    }
    
}
