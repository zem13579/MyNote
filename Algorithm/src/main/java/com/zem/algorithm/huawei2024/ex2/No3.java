package com.zem.algorithm.huawei2024.ex2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");

        Map<Character, String> map = new HashMap<>();
        char start = 'A';
        for (String string : split) {
            map.put(start, string);
            start = (char) (start + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (String cell : split) {
            int index1 = cell.indexOf('<');
            int index2 = cell.indexOf('>');

            if (index1 == -1 && index2 == -1) {
                sb.append(cell).append(",");
            } else if (index1 > index2 || index2 - index1 != 2) {
                System.out.println(-1);
                return;
            } else {
                sb.append(cell, 0, index1)
                        .append(map.get(cell.charAt(index1 + 1)))
                        .append(cell.substring(index2 + 1))
                        .append(",");
            }
        }

        System.out.println(sb.substring(0, sb.length() - 1));

    }
}
