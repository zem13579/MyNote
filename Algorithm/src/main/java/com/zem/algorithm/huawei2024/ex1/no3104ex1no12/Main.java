package com.zem.algorithm.huawei2024.ex1.no3104ex1no12;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 0,0,1,0,0,0,1,0,0
 * todo 提交通过
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] seats = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        int count = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0 && (i == 0 || seats[i - 1] == 0) && (i == seats.length - 1 || seats[i + 1] == 0)) {
                count++;
                seats[i] = 0;
                i++;
            }
        }

        System.out.println(count);
    }
}

