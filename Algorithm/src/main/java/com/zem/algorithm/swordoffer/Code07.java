package com.zem.algorithm.swordoffer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class Code07 {
    public static void main(String[] args) {

    }

    public static class MyQueue<T> {
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        public void appendTail(T item) {
            stack1.push(item);
        }

        public T deleteHead() {
            if (stack2.isEmpty()) {
                if (!stack1.isEmpty()) {
                    for (T item : stack1) {
                        stack2.push(item);
                    }
                }
            }
            if (stack2.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return stack2.pop();
        }

    }

    /**
     * 相关题目 用两个队列实现栈
     *
     * @param <T>
     */
    public static class MyStack<T> {
        private Queue<T> queue1 = new ArrayDeque<>();
    }
}
