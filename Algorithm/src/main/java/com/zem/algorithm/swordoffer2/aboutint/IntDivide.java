package com.zem.algorithm.swordoffer2.aboutint;

/**
 * @Describe 整数除法
 * 题目：输入2个int型整数，它们进行除法计算并返回商，要求不得使用乘号'*'、除号'/'及求余符号'%'。
 * 当发生溢出时，返回最大的整数值。假设除数不为0。例如，输入15和2，输出15/2的结果，即7。
 * @Author zem
 * @CreateDate 2023/12/4 0004 21:21
 */
public class IntDivide {
    public static void main(String[] args) {
        IntDivide intDivide = new IntDivide();
        System.out.println(intDivide.simpleSolution(100, 8));
        System.out.println(intDivide.quickWay(100, 8));
    }

    public int simpleSolution(int dividend, int divisor) {
        int sign = dividend * divisor > 0 ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0;
        while (dividend >= divisor) {
            quotient++;
            dividend -= divisor;
        }
        return quotient * sign;
    }

    public int quickWay(int dividend, int divisor) {
        int sign = dividend * divisor > 0 ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0;
        int count = 0;
        int sum = divisor;
        while (dividend >= sum) {
            quotient = (int) Math.pow(2.0, count * 1.0);
            count++;
            sum *= 2;
        }
        if (sum == 1) {
            return 0;
        } else {
            sum /= 2;
        }
        dividend -= sum;
        while (dividend > divisor) {
            quotient++;
            dividend -= divisor;
        }
        return quotient * sign;
    }
}
