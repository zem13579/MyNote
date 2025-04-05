package com.zem.algorithm.swordoffer;

import java.util.Arrays;

/**
 * 面试题12：打印1到最大的n位数
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
 */
public class Code12 {
    public static void main(String[] args) {
        Code12 code12 = new Code12();
        char[] number = "000123".toCharArray();
        boolean increment = code12.increment(number);
        System.out.println(increment);
        System.out.println(new String(number));
        code12.printNumber(number);
    }

    /**
     * 简单版本 没有考虑到输入n的范围 是否会超越int的最大值
     *
     * @param n
     */
    public void printToMaxOfNDigits(int n) {
        int number = 1;
        int i = 0;
        while (i++ < n) {
            number *= 10;
        }
        for (int j = i; j < number; j++) {
            System.out.println(j);
        }
    }

    public void printToMaxOfNDigits2(int n) {
        if (n < 0) {
            return;
        }
        char[] number = new char[n];
        Arrays.fill(number, '0');
        //字符串模拟加减运算
        while (increment(number)) {
            printNumber(number);
        }
    }

    public void printNumber(char[] number) {
        boolean needTrim = true;
        for (int i = 0; i < number.length; i++) {
            if (number[i] == '0' && needTrim) {
                continue;
            } else {
                if (needTrim) {
                    needTrim = false;
                }
                System.out.print(number[i]);
            }
        }
    }

    /**
     * @param number
     * @return
     */
    public boolean increment(char[] number) {
        boolean isOverflow = false;
        int nTakeOver = 0; //进位
        for (int i = number.length - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == number.length - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

}
