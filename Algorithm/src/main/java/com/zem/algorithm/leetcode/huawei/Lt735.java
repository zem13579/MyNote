package com.zem.algorithm.leetcode.huawei;

import java.util.*;

public class Lt735 {

    public static void main(String[] args) {
        Lt735 lt735 = new Lt735();
        int[] ints = lt735.asteroidCollision(new int[]{5, 10, -5});
        System.out.println(Arrays.toString(ints));
    }

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid >= 0) {
                stack.push(asteroid);
            } else {
                int abs = -asteroid;
                if (stack.isEmpty()) {
                    ans.add(asteroid);
                } else {
                    boolean bothend = false;
                    while (!stack.isEmpty()) {
                        if (stack.peek() < abs) {
                            stack.pop();
                        } else if (stack.peek() == abs) {
                            stack.pop();
                            bothend = true;
                            break;
                        } else {
                            break;
                        }
                    }
                    if (stack.isEmpty() && !bothend) {
                        ans.add(asteroid);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            ans.add(stack.pollLast());
        }
        int[] ints = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ints[i] = ans.get(i);
        }
        return ints;
    }
}
