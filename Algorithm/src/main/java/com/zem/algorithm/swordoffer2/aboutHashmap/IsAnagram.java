package com.zem.algorithm.swordoffer2.aboutHashmap;

import java.util.HashMap;

public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "cba"));
        System.out.println(isAnagram2("abc", "cba"));
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (char c : str1.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            if (counts[c - 'a'] == 0) {
                return false;
            }
            counts[c - 'a']--;
        }
        return true;
    }

    public static boolean isAnagram2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : str1.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toCharArray()) {
            if (counts.get(c) == 0) {
                return false;
            }
            counts.put(c, counts.get(c) - 1);
        }
        return true;
    }
}
