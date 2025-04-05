package com.zem.algorithm.huawei2024.ex1.no2531ex1no43;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int luckynum = sc.nextInt();
        int m = sc.nextInt();


        int luckyCount = 0;
        while (price != 0) {
            int mod = price % m;
            if (mod != 0) {
                if (mod == luckynum) {
                    luckyCount++;
                }
            }
            price = price / m;
        }
        System.out.println(luckyCount);
    }
}
