package com.zem.algorithm.leetcode.huawei;

public class Lt5 {
    public static void main(String[] args) {
        Lt5 lt5 = new Lt5();
        System.out.println(lt5.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        for (int subStrLen = 2; subStrLen <= len; subStrLen++) {
            for (int i = 0; i < subStrLen; i++) {
                int j = subStrLen + i - 1;
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);

    }

}
