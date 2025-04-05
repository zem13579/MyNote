package com.zem.algorithm.huawei2024.ex1;

import java.util.Scanner;

/**
 * todo 这种模拟题，一定要扯到 迭代里去，
 */
public class No76 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputLine = sc.nextLine().split(" ");
        int m = Integer.parseInt(inputLine[0]);
        int n = Integer.parseInt(inputLine[1]);
        
        int[] speeds = new int[m];
        for (int i = 0; i < speeds.length; i++) {
            speeds[i] = Integer.parseInt(sc.nextLine());
        }
        
        double[] arrivalTimes = new double[m];
        
        arrivalTimes[0] = (double) n / speeds[0];
        
        for (int index = 1; index < m; index++) {
            //加上延迟的时间
            double estimateTime = (double) n / speeds[index] + index;
            double adjustTime = Math.max(speeds[index - 1], estimateTime);
            arrivalTimes[index] = adjustTime;
        }
        //减去M的目的是因为减去延迟的时间（相对于第一台车而言），加一是因为时间从1开始算
        System.out.println(arrivalTimes[m - 1] - (m - 1));
    }
}
