package com.zem.algorithm.huawei2024.ex1.no2518ex1no52;

import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/9 0009 10:45 upf4jZL3bG9L03aF95eD38L99mi8K7y6CF9F3P65p9I0O30J-c3xmo71a0nm7
 * upf4jZL3bG9L03aF95eD38L99mi8K7y6CF9F3P65p9I0O30J-c3xmo71a0nm7
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] split = str.split("-");
        StringBuilder result = new StringBuilder(split[0]);
        for (int i = 1; i < split.length; i++) {
            String single = split[i];
            char[] charArray = single.toCharArray();
            StringBuilder tmp = new StringBuilder();
            int upper = 0, lower = 0;
            for (int j = 0; j < charArray.length; j++) {
                if (Character.isUpperCase(charArray[j])) {
                    upper++;
                } else if (Character.isLowerCase(charArray[j])) {
                    lower++;
                }
                tmp.append(charArray[j]);
                if ((j + 1) % k == 0 || j == charArray.length - 1) {
                    result.append("-");
                    if (upper > lower) {
                        result.append(tmp.toString().toUpperCase());
                    } else if (upper < lower) {
                        result.append(tmp.toString().toLowerCase());
                    } else {
                        result.append(tmp);
                    }
                    tmp = new StringBuilder();
                    upper = 0;
                    lower = 0;
                }
            }
        }
        System.out.print(result);
    }
}
