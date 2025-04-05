package com.zem.algorithm.huawei2024.ex1.no2557ex1noz29;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/6 0006 10:07
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> collect = Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
        collect.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return getkey(o1) - getkey(o2);
            }
            
            private int getkey(Integer m) {
                m = m < 0 ? -m : m;
                return m % 10;
            }
        });
        for (int i = 0; i < collect.size(); i++) {
            System.out.print(collect.get(i));
            if (i != collect.size() - 1) {
                System.out.print(",");
            }
        }
    }
}
