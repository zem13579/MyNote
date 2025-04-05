package com.zem.algorithm.swordoffer;

/**
 * @Describe 不用加减乘除做加法 其实就是让你模拟运算电路，用位运算做题
 * @Author zem
 * @CreateDate 2023/11/28 0028
 */
public class Code47 {
    public static void main(String[] args) {
        Code47 code47 = new Code47();
//        System.out.println(code47.add(11, 11));
        code47.exchangeValue(1, 2);
        code47.exchangeValue2(3, 4);
    }

    /**
     * 基于加减法交换两个变量的值
     *
     * @param num1
     * @param num2
     */
    public void exchangeValue(int num1, int num2) {
        System.out.printf(" before num1:%d,num2:%d\n", num1, num2);
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.printf(" after num1:%d,num2:%d\n", num1, num2);
    }


    /**
     * 基于异或交换连个变量的值
     *
     * @param num1
     * @param num2
     */
    public void exchangeValue2(int num1, int num2) {
        System.out.printf(" before num1:%d,num2:%d\n", num1, num2);
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.printf(" after num1:%d,num2:%d\n", num1, num2);
    }


    /**
     * 基于异或运算进行加法
     *
     * @param num1
     * @param num2
     * @return
     */

    public int add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        }
        while (num2 != 0);

        return num1;
    }
}
