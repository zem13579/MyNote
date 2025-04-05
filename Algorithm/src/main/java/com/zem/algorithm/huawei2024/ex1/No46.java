package com.zem.algorithm.huawei2024.ex1;

import java.util.Arrays;
import java.util.Scanner;

public class No46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        int k = sc.nextInt();
        if (k > s.length()) {
            char maxChar = charArray[charArray.length - 1];
            System.out.println(s.indexOf(maxChar));
        } else {
            char theChar = charArray[k - 1];
            System.out.println(s.indexOf(theChar));
        }
    }
}
