package com.zem.algorithm.leetcode.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lt39 {

    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        this.traceBack(candidates, target, current);
        return res.stream().toList();
    }

    private void traceBack(int[] candidates, int target, List<Integer> current) {
        if (target == 0) {
            res.add(current.stream().sorted().toList());
        }
        for (int candidate : candidates) {
            int next = target - candidate;
            if (next >= 0) {
                current.add(candidate);
                traceBack(candidates, next, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Lt39 lt39 = new Lt39();
        System.out.println(lt39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
