package com.zem.algorithm.swordoffer2.aboutString;

/**
 * 题目：给定一个字符串，请判断它是不是回文。假设只需要考虑字母和数字字符，
 * 并忽略大小写。例如，"Was it a cat I saw？"是一个回文字符串，而"race a car"不是回文字符串
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome("abba"));
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char chLeft = s.charAt(i);
            char chRight = s.charAt(j);
            if (!Character.isLetterOrDigit(chLeft)) {
                i++;
            } else if (!Character.isLetterOrDigit(chRight)) {
                j--;
            } else {
                chLeft = Character.toLowerCase(chLeft);
                chRight = Character.toLowerCase(chRight);
                if (chLeft != chRight) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
