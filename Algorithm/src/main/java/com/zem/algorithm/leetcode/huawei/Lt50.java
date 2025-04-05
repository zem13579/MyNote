package com.zem.algorithm.leetcode.huawei;

import java.math.BigDecimal;

public class Lt50 {
    public double myPow(double x, int n) {
        if(new BigDecimal(x).compareTo(new BigDecimal("1")) == 0){
            return 1.0;
        }
        double res = 1;
        int absN = Math.abs(n);
        while (absN > 0) {
            res *= x;
            --absN;
        }
        return n > 0 ? res : 1 / res;
    }
}
