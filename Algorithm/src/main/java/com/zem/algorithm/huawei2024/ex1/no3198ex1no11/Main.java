package com.zem.algorithm.huawei2024.ex1.no3198ex1no11;

import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/3 0003 8:54
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'o') {
                count++;
            }
        }
        System.out.println(count % 2 == 0 ? s.length() : s.length() - 1);
    }
}
