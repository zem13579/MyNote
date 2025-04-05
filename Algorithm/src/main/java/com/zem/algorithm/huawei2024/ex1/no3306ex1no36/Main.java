package com.zem.algorithm.huawei2024.ex1.no3306ex1no36;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 93,95,97,100,102,123,155
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = sc.nextInt();
        int pos = Arrays.binarySearch(arr, target);
        if (pos < 0) {
            pos = -pos - 1;
        }
        //加一是为了从1开始计数
        System.out.println(pos + 1);

    }
}
