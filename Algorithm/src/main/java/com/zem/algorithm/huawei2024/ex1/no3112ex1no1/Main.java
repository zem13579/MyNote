package com.zem.algorithm.huawei2024.ex1.no3112ex1no1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String l = sc.nextLine();

        int p1 = 0;
        int p2 = 0;
        int result = -1;
        int countCyCle = 0;
        while (p2 < l.length()) {
            if (s.charAt(p1) == l.charAt(p2)) {
                if (p1 == 0) {
                    result = p2;
                }
                if (p1 == s.length() - 1) {
                    countCyCle++;
                }
                p1 = (p1 + 1) % s.length();
            }
            p2++;
        }
        if (countCyCle > 0) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

}
