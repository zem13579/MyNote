package com.zem.algorithm.huawei2024.ex1.no2538ex1no9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int[] arr1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        int size2 = sc.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        List<Integer> sums = new ArrayList<>();

        for (int i : arr1) {
            for (int j : arr2) {
                sums.add(i + j);
            }
        }

        Integer sum = sums.stream().sorted().limit(k).reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
