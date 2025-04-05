package com.zem.algorithm.leetcode.huawei;

public class Lt739 {
    public static void main(String[] args) {
        Lt739 lt739 = new Lt739();
        lt739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int cur = temperatures[i];
            int last = temperatures[i + 1];
            if (cur >= last) {
                int sum = days[i + 1];
                int point = i + sum;
                while (cur >= temperatures[point] && days[point] != 0) {
                    sum += days[point];
                    point = i + sum;
                }
                if (cur < temperatures[point]) {
                    days[i] = sum ;
                }
            } else {
                days[i] = 1;
            }
        }
        return days;
    }
}
