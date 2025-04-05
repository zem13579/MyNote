package com.zem.algorithm.huawei2024.ex1.no2560ex1no30;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/6 0006 13:16
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        List<String> collect = map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue()).map(ele -> ele.getKey()+"").collect(Collectors.toList());
        System.out.println(String.join(",", collect));
    }
    
}
