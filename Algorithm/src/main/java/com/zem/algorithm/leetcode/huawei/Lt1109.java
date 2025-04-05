package com.zem.algorithm.leetcode.huawei;

public class Lt1109 {
    public static void main(String[] args) {

    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int seats = booking[2];
            for (int i = start; i <= end; i++) {
                ans[i - 1] += seats;
            }
        }
        return ans;
    }
}
