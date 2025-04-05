package com.zem.algorithm.huawei2024.ex1.no2607ex1no54;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class MainTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String express = sc.nextLine();
        sc.close();

        Deque<Integer> numbers = new ArrayDeque<>();
        char[] charArray = express.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isDigit(c)) {
                i = getAnInt(i, charArray, numbers);
            } else {
                //# 符优先级高于 $ 优先计算高优先级符号
                if ('#' == c) {
                    i = getAnInt(++i, charArray, numbers);
                    cal(numbers);
                }
            }
        }

        //由于符号$ x$y!=y$x 因此不能使用栈计算，从后弹出，必须使用队列，顺序计算
        while (numbers.size() != 1) {
            cal2(numbers);
        }

        System.out.println(numbers.pop());

    }

    private static int getAnInt(int i, char[] charArray, Deque<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        while (i < charArray.length && Character.isDigit(charArray[i])) {
            sb.append(charArray[i]);
            i++;
        }
        int num = Integer.parseInt(sb.toString());
        numbers.push(num);
        i--;
        return i;
    }

    private static void cal2(Deque<Integer> numbers) {
        Integer a = numbers.pollLast();
        Integer b = numbers.pollLast();
        numbers.addLast(2 * a + b + 3);
    }

    private static void cal(Deque<Integer> numbers) {
        Integer b = numbers.pop();
        Integer a = numbers.pop();
        numbers.push(4 * a + 3 * b + 2);
    }


}