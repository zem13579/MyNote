package com.zem.algorithm.huawei2024.ex1.no2820ex1no66;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] tmp = new int[s.length()];
        int index = s.indexOf('*', 0);
        while (index != -1) {
            tmp[index - 2] = 1;
            index = s.indexOf('*', index + 1);
        }
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (tmp[i] == 0) {
                sb.append(getRealChar(Integer.parseInt(charArray[i] + "")));
            } else {
                int j = Integer.parseInt("" + charArray[i] + charArray[i + 1]);
                sb.append(getRealChar(j));
                i = i + 2;
            }
        }
        System.out.println(sb);

    }

    private static Character getRealChar(int num) {
        return (char) ('a' + (num - 1));
    }
}
