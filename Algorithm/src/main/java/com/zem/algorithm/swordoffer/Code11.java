package com.zem.algorithm.swordoffer;

/**
 * 数值的整数次方
 * 输入
 * double base
 * int    exponent
 */
public class Code11 {
    public static void main(String[] args) {
        System.out.println(new Code11().Power(3, -1));
    }

    double Power(double base, int exponent) {
        double result = 1.0;
        int absExponent = Math.abs(exponent);
        result = powerWithUnsignedExponent(base, absExponent);
        if (exponent < 0) {
            //注意，double 类型的比较使用Double自带的equal 方法
            if (Double.valueOf(base).equals((double) 0L)) {
                throw new RuntimeException("非法输入，底数为0，且指数小于0");
            } else {
                return 1 / result;
            }
        }
        return result;
    }

    double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            return result;
        }
        return result;
    }
}
