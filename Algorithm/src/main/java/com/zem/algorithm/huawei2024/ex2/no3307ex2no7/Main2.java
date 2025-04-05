package com.zem.algorithm.huawei2024.ex2.no3307ex2no7;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int requireMonth = Integer.parseInt(sc.nextLine());
        int[] requirements = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(requirements);
        // todo
        int left = requirements[requirements.length - 1];
        //todo 因为题目中 需求的月数是大于 总需求数的一半
        int right = Arrays.stream(requirements).sum() / (requireMonth / 2) + 1;

        while (left < right) {
            int midHR = left + (right - left) / 2;
            int monthNeeded = getMonthNeeded(midHR, requirements);
            if (monthNeeded < requireMonth) {
                left = midHR + 1;
            } else {
                right = midHR;
            }
        }
        System.out.println(left);

    }

    private static int getMonthNeeded(int hr, int[] requirements) {
        int monthNeeded = 0;
        for (int i = requirements.length - 1, j = 0; i >= j; --i) {
            //todo 从后往前排查 同时大小搭配 尽量凑对
            if (i == j || requirements[i] + requirements[j] > hr) {
                monthNeeded++;
            } else {
                j++;
                monthNeeded++;
            }
        }
        return monthNeeded;
    }
}
