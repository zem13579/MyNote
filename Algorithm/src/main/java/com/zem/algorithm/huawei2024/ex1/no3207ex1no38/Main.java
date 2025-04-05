package com.zem.algorithm.huawei2024.ex1.no3207ex1no38;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] gems = new int[num];
        for (int i = 0; i < num; i++) {
            gems[i] = sc.nextInt();
        }
        int money = sc.nextInt();

        int left = 0, right = 0;
        int max = 0;
        int curPice = 0;
        while (right < num) {
            curPice += gems[right];
            if (curPice <= money) {
                int gemNum = right - left + 1;
                max = Math.max(gemNum, max);
            } else {
                curPice -= gems[left];
                left++;
            }
            right++;
        }
        System.out.println(max);
    }
}
