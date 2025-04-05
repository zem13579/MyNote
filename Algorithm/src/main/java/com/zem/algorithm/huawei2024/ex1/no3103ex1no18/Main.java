package com.zem.algorithm.huawei2024.ex1.no3103ex1no18;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/4 0004 8:47
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
