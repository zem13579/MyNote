package com.zem.algorithm.huawei2024.ex1.no2831ex1no61;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/12 0012 14:08
 */
public class Main {
    
    
    public static void main(String[] args) {
        Map<String, String> mapA = new HashMap<>();
        Map<String, String> mapB = new HashMap<>();
        Map<String, String> mapC = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            if ("A".equals(split[1])) {
                mapA.put(split[0], split[1]);
            }
            if ("B".equals(split[1])) {
                mapB.put(split[0], split[1]);
            }
            if ("C".equals(split[1])) {
                mapC.put(split[0], split[1]);
            }
        }
        if ((!mapA.isEmpty() && !mapB.isEmpty() && !mapC.isEmpty()) || (mapA.isEmpty() && mapB.isEmpty()
                && !mapC.isEmpty()) || (mapB.isEmpty() && mapC.isEmpty() && !mapA.isEmpty()) || (mapA.isEmpty()
                && mapC.isEmpty() && !mapB.isEmpty())) {
            System.out.println("NULL");
        } else if (!mapA.isEmpty() && !mapB.isEmpty()) {
            mapA.keySet().stream().sorted().forEach(System.out::println);
        } else if (!mapB.isEmpty() && !mapC.isEmpty()) {
            mapB.keySet().stream().sorted().forEach(System.out::println);
        } else if (!mapA.isEmpty() && !mapC.isEmpty()) {
            mapC.keySet().stream().sorted().forEach(System.out::println);
        }
        
        
    }
    
}
