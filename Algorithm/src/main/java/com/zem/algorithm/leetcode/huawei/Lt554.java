package com.zem.algorithm.leetcode.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lt554 {
    public int leastBricks(List<List<Integer>> wall) {
        List<List<Integer>> prefixSum = toPrefixSum(wall);

        long counter = 0;

        List<Integer> first = prefixSum.get(0);
        Integer totalWidth = first.get(first.size() - 1);


        for (List<Integer> integers : prefixSum) {
            for (Integer width : integers) {
                if (Objects.equals(width, totalWidth)) {
                    continue;
                }
                long count = prefixSum.stream().filter(list -> list.contains(width)).count();
                counter = Math.max(counter, count);
            }
        }
        return (int)(prefixSum.size() - counter);
    }

    private List<List<Integer>> toPrefixSum(List<List<Integer>> wall) {
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> integers : wall) {
            List<Integer> tmp = new ArrayList<>();
            int sum = 0;
            for (Integer i : integers) {
                sum += i;
                tmp.add(sum);
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Lt554 lt554 = new Lt554();
        int[][] wall = new int[][]{{1},{1},{1}};
        List<List<Integer>> wallList = new ArrayList<>();
        for (int[] ints : wall) {
            List<Integer> list = Arrays.stream(ints).boxed().toList();
            wallList.add(list);
        }
        System.out.println(lt554.leastBricks(wallList));
    }
}
