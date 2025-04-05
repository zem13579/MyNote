package com.zem.algorithm.huawei2024.ex1.no4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class No4Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int num = Integer.parseInt(s);

        int split = 1;
        int l = 0;
        List<List<String>> result = new ArrayList<>();

        while ((num - l) > 0) {
            if ((num - l) % split == 0) {
                int first = (num - l) / split;
                List<String> tmp = new ArrayList<>();
                for (int i = 0; i < split; i++) {
                    tmp.add(first + i + "");
                }
                result.add(tmp);
            }
            split++;
            l = l + (split - 1);
        }
        for (List<String> integers : result) {
            System.out.println(num + "=" + String.join("+", integers));
        }
        System.out.println("Result:" + result.size());
    }
}