package com.zem.algorithm.huawei2024.ex1.no3107ex1no63;


import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/12 0012 16:05
 */
public class Main {
    
    private static StringBuilder sb = new StringBuilder();
    
    private static int minSum = 0;
    
    private static void calNagetive() {
        if (sb.length() > 0) {
            int i = Integer.parseInt(sb.toString());
            minSum -= i;
            sb.delete(0, sb.length());
        }
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] charArray = s.toCharArray();
        boolean positive = true;
        for (char cur : charArray) {
            if (Character.isDigit(cur)) {
                if (positive) {
                    minSum += cur - '0';
                } else {
                    sb.append(cur);
                }
            } else if (cur == '-') {
                calNagetive();
                positive = false;
            } else if (cur == '+') {
                positive = true;
            } else {
                calNagetive();
                positive = true;
            }
        }
        calNagetive();
        System.out.println(minSum);
    }
    
    
}
