package com.zem.algorithm.huawei2024.ex1.no2532ex1no2;

import java.util.Arrays;
import java.util.Scanner;


class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawInput = scanner.nextLine();
        int[] input = Arrays.stream(rawInput.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] tmp = new int[input.length + 2];
        System.arraycopy(input, 0, tmp, 1, input.length);
        int count = 0;
        tmp[0] = -1;
        tmp[tmp.length - 1] = -1;
        for (int i = 1; i < tmp.length - 1; i++) {
            if (tmp[i] > tmp[i - 1] && tmp[i] > tmp[i + 1]) {
                count++;
            }
        }
        System.out.println(count);
    }
}