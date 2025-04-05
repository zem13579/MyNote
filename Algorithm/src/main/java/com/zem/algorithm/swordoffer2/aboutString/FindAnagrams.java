package com.zem.algorithm.swordoffer2.aboutString;

import java.util.LinkedList;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "cbadabacg";
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams(s1, s2));
    }

    public List<Integer> findAnagrams(String s1, String s2) {
        LinkedList<Integer> indices = new LinkedList<>();
        if (s2.length() < s1.length()) {
            return indices;
        }
        int[] counts = new int[26];
        int i = 0;
        for (; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        if (allZero(counts)) {
            indices.add(0);
        }
        for (; i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--; //右指针
            counts[s2.charAt(i - s1.length()) - 'a']++; //左指针,指向去除的字母
            if (allZero(counts)) {
                //此处需要+1，因为左指针指向去除的字母。是开始字母的左侧
                indices.add(i - s1.length() + 1);
            }
        }
        return indices;
    }

    private boolean allZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
