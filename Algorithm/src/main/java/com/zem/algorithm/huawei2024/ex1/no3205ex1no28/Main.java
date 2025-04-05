package com.zem.algorithm.huawei2024.ex1.no3205ex1no28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/6 0006 9:14
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Character> collect =
                s.toLowerCase().chars()
                        .filter(Character::isLetter)
                        .mapToObj(x -> (char) x)
                        .collect(Collectors.toList());
        collect.add(' ');
        int[] charCount = new int[128];
        for (Character c : collect) {
            charCount[c]++;
        }
        List<Pair> list = new ArrayList<>();

        Character pre = collect.get(0);
        int repeat = 1;
        charCount[pre]--;

        for (int i = 1; i <collect.size(); i++) {
            Character cur = collect.get(i);
            charCount[cur]--;
            if (cur == pre) {
                repeat++;
            } else {
                Pair pair = new Pair(pre, repeat > 1 ? repeat : charCount[pre]);
                list.add(pair);
                pre = cur;
                repeat = 1;
            }
        }

        Collections.sort(list);

        for (Pair pair : list) {
            System.out.print(pair.key + "" + pair.times);
        }
        System.out.println();

    }

    static class Pair implements Comparable<Pair> {
        private Character key;
        private int times;

        public Pair(char key, int times) {
            this.key = key;
            this.times = times;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.times - pair.times == 0) {
                return this.key - pair.key;
            } else {
                return  pair.times - this.times;
            }

        }

    }
}
