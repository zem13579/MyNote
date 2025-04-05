package com.zem.algorithm.huawei2024.ex2.no4205ex2no8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int toleratedAverageLoss = Integer.parseInt(sc.nextLine());
        int[] losts = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] cumulativeSum = new int[losts.length];
        cumulativeSum[0] = losts[0];
        for (int i = 1; i < losts.length; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + losts[i];
        }

        List<int[]> result = new ArrayList<>();

        int maxLength = 0;

        for (int start = 0; start < losts.length; start++) {
            for (int end = start; end < losts.length; end++) {
                int sum = start == 0 ? cumulativeSum[end] : cumulativeSum[end] - cumulativeSum[start - 1];
                int length = end - start + 1;
                int toleratedLoss = length * toleratedAverageLoss;
                if (sum <= toleratedLoss) {
                    if (length > maxLength) {
                        result = new ArrayList<>();
                        result.add(new int[]{start, end});
                        maxLength = length;
                    } else if (length == maxLength) {
                        result.add(new int[]{start, end});
                    }
                }
            }
        }

        if (result.isEmpty()) {
            System.out.println("NULL");
        } else {
            result.sort(Comparator.comparingInt(x -> x[0]));
            StringJoiner sj = new StringJoiner(" ");
            for (int[] ints : result) {
                sj.add(ints[0] + "-" + ints[1]);
            }
            System.out.println(sj);
        }

    }
}
