package com.zem.algorithm.huawei2024.ex1.no2605ex1no6;

import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/2 0002 10:06
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        boolean vad = false;
        boolean containUpper = false;
        boolean containLower = false;
        boolean containNumber = false;
        boolean containSpecial = false;
        
        for (char c : input.toCharArray()) {
            if (c == '<') {
                if (sb.length() - 1 >= 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c >= 'a' && c <= 'z') {
                containLower = true;
            } else if (c >= 'A' && c <= 'Z') {
                containUpper = true;
            } else if (c >= '0' && c <= '9') {
                containNumber = true;
            } else if (c != ' ') {
                containSpecial = true;
            }
        }
        //1. 密码长度>=8;
        if (sb.length() >= 8 && containNumber && containUpper && containLower && containSpecial) {
            vad = true;
        }
        System.out.println(sb + "," + vad);
    }
}
