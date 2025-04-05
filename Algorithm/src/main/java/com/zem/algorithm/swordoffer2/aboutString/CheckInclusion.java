package com.zem.algorithm.swordoffer2.aboutString;

public class CheckInclusion {
    public static void main(String[] args) {
        String s1 = "ac";
        String s2 = "dgcaf";
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInslusion(s1, s2));
    }

    public boolean checkInslusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        if (allZero(counts)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--;
            counts[s2.charAt(i - s1.length()) - 'a']++;
            if (allZero(counts)) {
                return true;
            }
        }
        return false;
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
