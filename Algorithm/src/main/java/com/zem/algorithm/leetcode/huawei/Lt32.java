package com.zem.algorithm.leetcode.huawei;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2025/2/28 0028 14:41
 */
public class Lt32 {

    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
