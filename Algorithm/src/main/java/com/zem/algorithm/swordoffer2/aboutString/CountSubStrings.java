package com.zem.algorithm.swordoffer2.aboutString;

/**
 * 回文子字符串的个数
 * <p>
 * 题目：给定一个字符串，请问该字符串中有多少个回文连续子字符串？
 * 例如，字符串"abc"有3个回文子字符串，分别为"a"、"b"和"c"；
 * 而字符串"aaa"有6个回文子字符串，分别为"a"、"a"、"a"、"aa"、"aa"和"aaa"。
 */
public class CountSubStrings {
    public static void main(String[] args) {
        CountSubStrings countSubStrings = new CountSubStrings();
        System.out.println(countSubStrings.countSubStrings("aaa"));
    }

    public int countSubStrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    private int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }


}
