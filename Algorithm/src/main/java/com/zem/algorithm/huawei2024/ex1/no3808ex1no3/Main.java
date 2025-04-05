package com.zem.algorithm.huawei2024.ex1.no3808ex1no3;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.split(" ");
        int count = solve(split[0], Integer.parseInt(split[1]));
        System.out.println(count);
    }
    
    private static final Set<String> count = new HashSet<>();
    
    public static int solve(String str, int n) {
        char[] charArray = str.toCharArray();
        boolean[] markarr = new boolean[str.length()];
        StringBuilder tmp = new StringBuilder();
        backtrace(charArray, markarr, tmp, n);
        return count.size();
    }
    
    private static  void  backtrace(char[] charArray, boolean[] markArr, StringBuilder tmp, int n) {
        if (tmp.length() == n) {
            count.add(tmp.toString());
            return;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (!markArr[i]) {
                if (tmp.length() != 0 && tmp.charAt(tmp.length() - 1) == charArray[i]) {
                    continue;
                }
                tmp.append(charArray[i]);
                markArr[i] = true;
                backtrace(charArray, markArr, tmp, n);
                tmp.deleteCharAt(tmp.length() - 1);
                markArr[i] = false;
            }
        }
    }
}
