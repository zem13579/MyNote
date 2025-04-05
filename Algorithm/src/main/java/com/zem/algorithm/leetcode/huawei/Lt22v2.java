package com.zem.algorithm.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;

public class Lt22v2 {
    public static void main(String[] args) {
        Lt22v2 lt22 = new Lt22v2();
        System.out.println(lt22.generateParenthesis(3));

    }

    int max;

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        max = n;
        backTrace(ans, new StringBuilder(), 0, 0);
        return ans;
    }

    private void backTrace(List<String> ans, StringBuilder cur, int openNum, int closeNum) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (openNum < max) {
            cur.append("(");
            backTrace(ans, cur, openNum + 1, closeNum);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (closeNum < openNum) {
            cur.append(")");
            backTrace(ans, cur, openNum, closeNum + 1);
            cur.deleteCharAt(cur.length() - 1);
        }

    }


}
