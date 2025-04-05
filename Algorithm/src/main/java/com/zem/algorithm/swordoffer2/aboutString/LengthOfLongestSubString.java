package com.zem.algorithm.swordoffer2.aboutString;

public class LengthOfLongestSubString {
    public static void main(String[] args) {
        String s = "babcca";
        LengthOfLongestSubString lengthOfLongestSubString = new LengthOfLongestSubString();
        System.out.println(lengthOfLongestSubString.lengthOfLongestSubString(s));
    }

    public int lengthOfLongestSubString(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        int right = 0;
        int left = -1;
        int longest = 1;
        for (; right < s.length(); right++) {
            counts[s.charAt(right)]++;
            while (hasGreaterThan1(counts)) {
                ++left;
                counts[s.charAt(left)]--;
            }
            longest = Math.max(right - left, longest);
        }
        return longest;
    }

    private boolean hasGreaterThan1(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}
