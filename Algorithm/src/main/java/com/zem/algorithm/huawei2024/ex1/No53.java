package com.zem.algorithm.huawei2024.ex1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/9 0009 13:18
 */
public class No53 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        
        char[] charArray = s.toCharArray();
        Map<Character, Integer> itemCount = new HashMap<>();
        char lastchar = charArray[0];
        int i = 1;
        while (i < charArray.length) {
            int count = 1;
            char cur = charArray[i];
            while (cur == lastchar) {
                lastchar = cur;
                if (++i > charArray.length - 1) {
                    break;
                }
                cur = charArray[i];
                count++;
            }
            itemCount.merge(lastchar, count, Math::max);
            lastchar = cur;
            i++;
        }
        List<Map.Entry<Character, Integer>> entryList = itemCount.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue()).collect(Collectors.toList());
        if (k > entryList.size()) {
            System.out.println(-1);
        } else {
            System.out.println(entryList.get(k - 1).getValue());
        }
    }
    
}
