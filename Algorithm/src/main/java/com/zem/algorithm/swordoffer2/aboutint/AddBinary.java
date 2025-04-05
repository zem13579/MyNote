package com.zem.algorithm.swordoffer2.aboutint;

/**
 * @Describe 字符串二进制加法
 * 题目：输入两个表示二进制的字符串，请计算它们的和，并以二进制字符串的形式输出。例如，输入的二进制字符串分别是"11"和"10"，则输出"101"。
 * @Author zem
 * @CreateDate 2023/12/4 0004 22:36
 */
public class AddBinary {
    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("1111111", "111111"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int c = (i >= 0 ? a.charAt(i--) : '0') - '0';
            int d = (j >= 0 ? b.charAt(j--) : '0') - '0';
            int sum = c + d + carry;
            if (sum >= 2) {
                sum = sum - 2;
                carry = 1;
            }
            sb.append(sum);
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
