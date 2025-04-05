package com.zem.algorithm.huawei2024.ex1.no2813ex1no73;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/13 0013 16:52
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] priority = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            priority[i] = sc.nextInt();
        }
        sc.nextLine();
        Map<Integer, Integer> demoMap = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int p : array) {
                demoMap.merge(i, priority[p], Integer::sum);
            }
        }
        
        demoMap.entrySet().stream().sorted((o1, o2) -> {
            int value = o2.getValue() - o1.getValue();
            if (value == 0) {
                return o1.getKey() - o2.getKey();
            }
            return value;
        }).forEach(integerIntegerEntry -> System.out.println(integerIntegerEntry.getKey()));
        
    }
}
