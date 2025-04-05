package com.zem.algorithm.leetcode.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lt386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        res.sort(Comparator.comparing(String::valueOf));
        return res;
    }
}
