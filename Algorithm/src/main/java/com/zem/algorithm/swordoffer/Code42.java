package com.zem.algorithm.swordoffer;

/**
 * @Describe 42：翻转单词顺序 VS左旋转字符串
 * @Author zem
 * @CreateDate 2023/11/24 0024
 */
public class Code42 {
    public static void main(String[] args) {
        String str = "abcdefg";
        Code42 code42 = new Code42();
        System.out.println(code42.rightRotateString(str, 2));
    }

    /**
     * @param bytes
     * @param start
     * @param end
     * @return
     */
    public byte[] reverse(byte[] bytes, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException(" start lager than end ");
        }
        for (int i = start, j = end - 1; i < bytes.length && i < j; i++, j--) {
            byte tmp = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = tmp;
        }
        return bytes;
    }

    /**
     * 左移字符串
     *
     * @param str
     * @param num
     * @return
     */
    public String leftRotateString(String str, int num) {
        byte[] bytes = str.getBytes();
        //翻转开头num个字符
        reverse(bytes, 0, num);
        //翻转其余字符
        reverse(bytes, num, bytes.length);
        //翻转整个数组
        reverse(bytes, 0, bytes.length);

        return new String(bytes);
    }

    /**
     * 右旋字符串
     *
     * @param str
     * @param num
     * @return
     */
    public String rightRotateString(String str, int num) {
        byte[] bytes = str.getBytes();
        reverse(bytes, bytes.length - num, bytes.length);
        reverse(bytes, 0, bytes.length - num);
        reverse(bytes, 0, bytes.length);

        return new String(bytes);
    }
}
