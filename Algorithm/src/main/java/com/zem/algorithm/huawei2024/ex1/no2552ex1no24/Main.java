package com.zem.algorithm.huawei2024.ex1.no2552ex1no24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        arr.sort((o1, o2) -> {
            int diff1 = Math.abs(o1 - h);
            int diff2 = Math.abs(o2 - h);
            if (diff1 == diff2) {
                return o1 - o2;
            }
            return diff1 - diff2;
        });

        arr.forEach(x -> System.out.print(x+" "));
        System.out.println();
    }
}
