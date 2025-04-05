package com.zem.algorithm.huawei2024.ex1.no2706ex1no41;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groupA = sc.nextInt();
        int groupB = sc.nextInt();

        int totalPowerGroupA = 0;
        int[] powerGroupA = new int[groupA];
        for (int i = 0; i < groupA; i++) {
            powerGroupA[i] = sc.nextInt();
            totalPowerGroupA += powerGroupA[i];
        }

        int totalPowerGroupB = 0;
        Map<Integer, Integer> powerCountGroupB = new HashMap<>();
        for (int i = 0; i < groupB; i++) {
            int power = sc.nextInt();
            totalPowerGroupB += power;
            powerCountGroupB.merge(power, 1, Integer::sum);
        }

        int halfdiff = (int) Math.round((totalPowerGroupA - totalPowerGroupB) / 2.0);

        //排序是为了尽量小
        Arrays.sort(powerGroupA);

        for (int powerA : powerGroupA) {
            int powerB = powerA - halfdiff;
            if (powerCountGroupB.containsKey(powerB) && powerCountGroupB.get(powerB) > 0) {
                System.out.println(powerA + " " + powerB);
                break;
            }

        }

    }
}
