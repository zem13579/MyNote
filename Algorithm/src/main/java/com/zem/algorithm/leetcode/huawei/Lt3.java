package com.zem.algorithm.leetcode.huawei;

public class Lt3 {
    public static void main(String[] args) {
        Lt3 lt3 = new Lt3();
        System.out.println(lt3.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lt3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lt3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lt3.lengthOfLongestSubstring("b"));
        System.out.println(lt3.lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            int indexOfChar = s.indexOf(s.charAt(right), left, right );
            if (indexOfChar != -1) {

                left = indexOfChar + 1;
            }
            right++;

            int length = right - left ;
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}
