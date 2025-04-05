package com.zem.algorithm.huawei2024.ex1.no2829ex1no7;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/2 0002 10:42
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        Map<String, Integer> countMap = new HashMap<>();
        for (String string : arr) {
            countMap.merge(string, 1, Integer::sum);
        }
        List<Map.Entry<String, Integer>> list = countMap.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue()).collect(Collectors.toList());
        int max = list.get(0).getValue();
        List<Integer> ordedList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() == max) {
                ordedList.add(Integer.parseInt(entry.getKey()));
            }
        }
        Collections.sort(ordedList);
        int size = ordedList.size();
        if (size % 2 == 0) {
            int i = (ordedList.get(size / 2) + ordedList.get(size / 2 - 1) )/ 2;
            System.out.println(i);
        } else {
            System.out.println(ordedList.get(size / 2));
        }
        List<Integer> inputs = new ArrayList<>();
        inputs.sort(Integer::compareTo);
    }
    
}
