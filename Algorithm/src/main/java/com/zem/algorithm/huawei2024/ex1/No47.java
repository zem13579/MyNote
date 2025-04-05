package com.zem.algorithm.huawei2024.ex1;

import java.util.Scanner;

public class No47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        String first = split[0];
        String second = split[1];
        if (first.endsWith("/") && second.endsWith("/")) {
            System.out.println(first.substring(0, first.length() - 1) + second);
        } else if (!first.endsWith("/") && !second.endsWith("/")) {
            System.out.println(first + "/" + second);
        } else {
            System.out.println(first + second);
        }
    }
}
