package com.zem.algorithm.swordoffer2.aboutBinSearch;

public class MySqrt {
    public int mySqrt(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < n / mid) {
                if ((mid + 1) > n / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
