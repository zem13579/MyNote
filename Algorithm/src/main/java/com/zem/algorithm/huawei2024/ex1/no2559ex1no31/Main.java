package com.zem.algorithm.huawei2024.ex1.no2559ex1no31;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/6 0006 13:28
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        String[][] data = new String[n][m + 1];
        List<String> subjects = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextLine().split(" ");
        }
        String orderSub = sc.nextLine();
        List<String[]> orderd = Arrays.stream(data).sorted((o1, o2) -> {
            int diff = extracted(o1, o2, subjects, orderSub);
            if (diff == 0) {
                return o1[0].compareTo(o2[0]);
            }
            return diff;
        }).collect(Collectors.toList());
        for (String[] strings : orderd) {
            System.out.print(strings[0] + " ");
        }
        System.out.println();
    }
    
    private static int extracted(String[] o1, String[] o2, List<String> subjects, String orderSub) {
        if (subjects.contains(orderSub)) {
            int index = subjects.indexOf(orderSub);
            return Integer.parseInt(o1[index]) - Integer.parseInt(o2[index]);
        }
        int sum1 = 0;
        for (int i = 1; i < o1.length; i++) {
            sum1 += Integer.parseInt(o1[i]);
        }
        int sum2 = 0;
        for (int i = 1; i < o2.length; i++) {
            sum2 += Integer.parseInt(o2[i]);
        }
        return sum1 - sum2;
    }
}
