package com.zem.algorithm.huawei2024.ex1.no10;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 找出作弊的人
 */
public class No10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(sc.nextInt(), sc.nextInt());
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
                .sorted((Comparator.comparingInt(Map.Entry::getValue))).collect(Collectors.toList());

        TreeMap<Integer, List<List<Integer>>> diffMap = getIntegerListTreeMap(list);
        diffMap.firstEntry().getValue().forEach(pair -> System.out.println(pair.get(0) + " " + pair.get(1)));
    }

    private static TreeMap<Integer, List<List<Integer>>> getIntegerListTreeMap(List<Map.Entry<Integer, Integer>> list) {
        TreeMap<Integer, List<List<Integer>>> diffMap = new TreeMap<>();
        for (int i = 1; i < list.size(); i++) {
            Map.Entry<Integer, Integer> last = list.get(i - 1);
            Map.Entry<Integer, Integer> cur = list.get(i);
            int diff = cur.getValue() - last.getValue();
            List<List<Integer>> listList = diffMap.get(diff);
            List<Integer> pair = Arrays.asList(last.getKey(), cur.getKey());
            if (listList == null) {
                listList = new ArrayList<>();
            }
            listList.add(pair);
            diffMap.put(diff, listList);
        }
        return diffMap;
    }
}















