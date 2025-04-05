package com.zem.algorithm.swordoffer2.aboutBinSearch;

public class MinEatingSpeed {

    public static void main(String[] args) {
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        System.out.println(minEatingSpeed.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1;
        int right = max;
        while (left <= left) {
            int mid = left + (right - left) / 2;
            int hours = getHours(piles, mid);
            if (hours <= H) {
                if (mid == 1 || getHours(piles, mid - 1) > H) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int getHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil(pile * 1.0 / speed);
        }
        return hours;
    }
}
