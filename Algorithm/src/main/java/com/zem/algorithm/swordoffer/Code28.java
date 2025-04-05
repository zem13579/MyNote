package com.zem.algorithm.swordoffer;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author zem
 * @Date 2023/10/21
 * @Describe 字符串的排列
 */
public class Code28 {

    private StringBuilder stringBuilder = new StringBuilder();
    private char[] strArr = null;

    public static void main(String[] args) {
        Code28 code28 = new Code28();
//        code28.permutation("abcd");
//        StringBuilder stringBuilder = new StringBuilder("1").replace(0, 1, "");
//        System.out.println(stringBuilder);
//        StringBuilder stringBuilder1 = stringBuilder.replace(1, 2, "");
//        System.out.println(stringBuilder1);
//        StringBuilder stringBuilder2 = stringBuilder1.replace(2, 3, "");
//        System.out.println(stringBuilder2);
        String str = "abc";
        for (int i = 0; i < str.length(); i++) {
            code28.zuhe(str, i + 1);
        }
//        code28.javaApi("abc");

//        code28.permutation("abc");
    }


    /**
     * 书中的全排列
     *
     * @param str
     */
    private void permutation(String str) {
        this.strArr = str.toCharArray();
        doPermutation(0);
    }

    private void doPermutation(int begin) {
        if (begin == strArr.length) {
            System.out.println(new String(strArr));
        } else {
            for (int i = begin; i < strArr.length; i++) {
                Character tmp = strArr[begin];
                strArr[begin] = strArr[i];
                strArr[i] = tmp;

                doPermutation(begin + 1);

                tmp = strArr[begin];
                strArr[begin] = strArr[i];
                strArr[i] = tmp;

            }
        }
    }


    /**
     * 使用自己的方法
     *
     * @param str
     */
    private void permutation2(String str) {
        if (str.isEmpty()) {
            System.out.println(stringBuilder);
            return;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            stringBuilder.append(charArray[i]);
            String newStr = new StringBuilder(str).replace(i, i + 1, "").toString();
            permutation2(newStr);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    //求字符的所有组合
    private void zuhe(String str, int length) {
        if (stringBuilder.length() == length) {
            System.out.println(stringBuilder);
            return;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            stringBuilder.append(charArray[i]);
            String newStr = new StringBuilder(str).replace(0, i + 1, "").toString();
            zuhe(newStr, length);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }

    public void javaApi(String str) {
        Collections.shuffle(Arrays.asList(str));
        System.out.println(str);
    }
}
