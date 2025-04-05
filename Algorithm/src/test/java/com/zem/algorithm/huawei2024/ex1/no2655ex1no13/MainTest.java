package com.zem.algorithm.huawei2024.ex1.no2655ex1no13;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] prices = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < prices.length; i++) {
            int total = prices[i];
            int next = (i + 1) % prices.length;
            while (next != i) {
                if (prices[next] < prices[i]) {
                    total += prices[next];
                    break;
                }
                next = (next + 1) % prices.length;
            }
            System.out.print(total + " ");

        }
    }
}