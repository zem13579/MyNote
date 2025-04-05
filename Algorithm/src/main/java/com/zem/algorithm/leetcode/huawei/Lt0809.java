package com.zem.algorithm.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;

import com.zem.algorithm.huawei2024.ex1.no2518ex1no52.Main;

public class Lt0809 {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        this.generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    private void generateAll(char[] current, int pos, List<String> combinations) {
        if (pos == current.length) {
            if (valid(current)) {
                combinations.add(new String(current));
                return;
            }
        }
        current[pos] = '(';
        generateAll(current, pos + 1, combinations);
        current[pos] = ')';
        generateAll(current, pos + 1, combinations);

    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if ('(' == c) {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        new Lt0809().generateParenthesis(3);
    }
}
