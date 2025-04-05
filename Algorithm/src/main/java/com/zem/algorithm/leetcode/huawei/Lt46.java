package com.zem.algorithm.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;

public class Lt46 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        this.traceBack(nums, current, visited);
        return ans;
    }

    private void traceBack(int[] nums, List<Integer> current, boolean[] visited) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                traceBack(nums, current, visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Lt46 lt46 = new Lt46();
        System.out.println(lt46.permute(new int[]{1}));
    }
}
