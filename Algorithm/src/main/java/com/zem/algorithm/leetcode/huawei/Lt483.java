package com.zem.algorithm.leetcode.huawei;

import java.util.*;

public class Lt483 {
    public static void main(String[] args) {
        Lt483 lt483 = new Lt483();
        List<Integer> anagrams = lt483.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }

    public List<Integer> findAnagrams(String s, String p) {

        if(s.length()<p.length()){
            return new ArrayList<>();
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        List<Integer> res = new ArrayList<>();
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }


        int left = 0;

        while (left < s.length() - p.length()) {
            --sCount[s.charAt(left) - 'a'];
            ++sCount[s.charAt(left + p.length()) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                res.add(left + 1);
            }

            left++;
        }
        return res;
    }

}
