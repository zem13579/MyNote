package com.zem.algorithm.huawei2024.ex1.no2703ex1no45;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wrods = sc.nextLine();
        String pre = sc.nextLine();

        List<String> predict = Arrays.stream(wrods.split(" "))
                .flatMap(x -> Arrays.stream(x.split("'")))
                .filter(x -> !"".equals(x))
                .filter(x -> x.startsWith(pre))
                .sorted().collect(Collectors.toList());
        if (predict.isEmpty()) {
            System.out.println(pre);
        } else {
            predict.forEach(str -> System.out.print(str + " "));
        }
        System.out.println();
    }
}
