package com.zem.algorithm.huawei2024.ex2.no2526ex2no16;

import java.util.Scanner;

public class Main {

    static int profix = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wa = sc.nextInt();
        int wb = sc.nextInt();
        int wt = sc.nextInt();
        int pa = sc.nextInt();
        int pb = sc.nextInt();


        System.out.println(findMaxProfix(wa, wb, wt, pa, pb));

    }

    private static int findMaxProfix( int wa, int wb, int wt, int pa, int pb) {

        int maxNumA = (wt - wb) / wa;
        int maxNumB = (wt - wa) / wb;

        int profix = 0;
        for (int numA = 1; numA <= maxNumA; numA++) {
            for (int numB = 1; numB <= maxNumB; numB++) {
                int totalW = numA * wa + numB * wb;
                if (totalW == wt) {
                    int totalProfix = numA * pa + numB * pb;
                    if (totalProfix > profix) {
                        profix = totalProfix;
                    }
                }
            }
        }
        return profix;
    }
}
