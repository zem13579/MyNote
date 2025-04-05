package com.zem.algorithm.leetcode.huawei;

import java.util.*;

public class Lt22 {
    public static void main(String[] args) {
        Lt22 lt22 = new Lt22();
        System.out.println(lt22.generateParenthesis(3));

    }

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[n * 2], 0, combinations);
        return combinations;
    }

    private void generateAll(char[] current, int pos, List<String> combinations) {
        if (pos == current.length) {
            if (valid(current)) {
                combinations.add(new String(current));
            }
            return;
        }
        current[pos] = '(';
        generateAll(current, pos + 1, combinations);
        current[pos] = ')';
        generateAll(current, pos + 1, combinations);
    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
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


}
