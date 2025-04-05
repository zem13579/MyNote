package com.zem.algorithm.huawei2024.ex1.no3150ex1no33;


import java.util.Arrays;
import java.util.Scanner;

class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] charArray = line.toCharArray();
        //find mini
        char[] charSort = Arrays.copyOf(charArray, charArray.length);
        Arrays.sort(charSort);
        for (int i = 0; i < charSort.length; i++) {
            if (charArray[i] != charSort[i]) {
                int index = line.indexOf(charSort[i]);
                //exchange index i
                char tmp = charArray[index];
                charArray[index] = charArray[i];
                charArray[i] = tmp;
                break;
            }
        }
        String s = new String(charArray);
        System.out.println(s);

    }
}