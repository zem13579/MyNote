package com.zem.algorithm.leetcode.huawei;

import java.util.Arrays;

public class Lt2120 {
    public static void main(String[] args) {
        Lt2120 lt2120 = new Lt2120();
        int[] ans = lt2120.executeInstructions(3, new int[]{0, 1}, "RRDDLU");
        System.out.println(Arrays.toString(ans));
    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int length = s.length();
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {

            int x = startPos[0];
            int y = startPos[1];
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                char order = s.charAt(j);
                if ('L' == order) {
                    y--;
                } else if ('R' == order) {
                    y++;
                } else if ('U' == order) {
                    x--;
                } else if ('D' == order) {
                    x++;
                }
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    count++;
                } else {
                    break;
                }
            }

            ans[i] = count;


        }
        return ans;
    }
}
