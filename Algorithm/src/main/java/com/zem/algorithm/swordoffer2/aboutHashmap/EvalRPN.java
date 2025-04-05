package com.zem.algorithm.swordoffer2.aboutHashmap;

import java.util.Stack;

public class EvalRPN {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "3", "*", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if ("-".equals(tokens[i])) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if ("*".equals(tokens[i])) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if ("/".equals(tokens[i])) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
