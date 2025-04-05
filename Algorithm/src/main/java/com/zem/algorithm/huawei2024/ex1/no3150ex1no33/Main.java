package com.zem.algorithm.huawei2024.ex1.no3150ex1no33;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String minStr = str;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) > str.charAt(j)) {
                    String tmpStr = exchange(str, i, j);
                    if (tmpStr.compareTo(minStr) < 0) {
                        minStr = tmpStr;
                    }
                }
            }
        }
        System.out.println(minStr);
    }

    private static String exchange(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
        return new String(charArray);
    }

}
