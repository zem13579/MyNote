package com.zem.algorithm.leetcode.huawei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Lt394 {
    public static void main(String[] args) {
        Lt394 lt394 = new Lt394();
        System.out.println(lt394.decodeString("dd3[a2[c]b]q"));
        System.out.println(lt394.decodeString("100[leetcode]"));
    }

    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        StringBuilder tmpNum = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                tmpNum.append(c);
            } else if ('[' == c) {
                int num = Integer.parseInt(tmpNum.toString());
                numStack.push(num);
                stack.push(c);
                tmpNum = new StringBuilder();
            } else if (']' == c) {
                int times = numStack.pop();
                StringBuilder sb = new StringBuilder();
                while (true) {
                    Character pop = stack.pop();
                    if (pop == '[') {
                        break;
                    } else {
                        sb.append(pop);
                    }
                }
                for (int k = 0; k < times; k++) {
                    for (int j = sb.length() - 1; j > -1; j--) {
                        stack.push(sb.charAt(j));
                    }
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        Iterator<Character> iterator = stack.reversed().iterator();
        while (iterator.hasNext()) {
            res.append(iterator.next());
        }
        return res.toString();
    }
}
