package com.zem.algorithm.huawei2024.ex1.no2820ex1no66;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String encoded = sc.nextLine();
        sc.close();
        char[] charArray = encoded.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (i + 2 < charArray.length && charArray[i + 2] == '*') {
                int num = Integer.parseInt(charArray[i] + "" + charArray[i + 1]);
                sb.append(getRealChar(num));
                i = i + 2;
            } else {
                sb.append(getRealChar(Integer.parseInt(charArray[i] + "")));
            }
        }
        System.out.println(sb);
    }

    private static Character getRealChar(int num) {
        return (char) ('a' + (num - 1));
    }
}