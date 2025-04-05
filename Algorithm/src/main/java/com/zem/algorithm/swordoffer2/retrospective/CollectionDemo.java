package com.zem.algorithm.swordoffer2.retrospective;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 2024年05月13日 23:41:27
 * 回溯法 所有集合
 */
public class CollectionDemo {
    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) return result;
        helper(nums, 0, new LinkedList<Integer>(), result);
        return result;
    }

    private static void helper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new LinkedList<>(subset));
        } else {
            helper(nums, index + 1, subset, result);
            subset.add(nums[index]);
            helper(nums, index + 1, subset, result);
            subset.removeLast();
        }

    }

    public static void main(String[] args) {
        System.out.println(subset(new int[]{1, 2, 3}));
    }
}
