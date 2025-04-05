package com.zem.algorithm.huawei2024.ex1.no3807ex1no16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static Integer miniDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] scores = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> tmp = new ArrayList<>();
        int currentIndex = 0;
        backTrace2(scores, tmp, currentIndex);
        System.out.println(miniDiff);
    }

    private static void backTrace2(int[] scores, List<Integer> tmp, int nextIndex) {
        if (tmp.size() == 5) {
            int team1 = tmp.stream().reduce(0, Integer::sum);
            int team2 = Arrays.stream(scores).sum() - team1;
            int diff = Math.abs(team2 - team1);
            if (diff < miniDiff) {
                miniDiff = diff;
            }
            return;
        }

        for (int i = nextIndex; i < scores.length; i++) {
            tmp.add(scores[i]);
            backTrace2(scores, tmp, i + 1);
            tmp.removeLast();
        }
    }
}