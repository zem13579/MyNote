package com.zem.algorithm.huawei2024.ex1.no5;

import java.util.HashMap;
import java.util.Map;

/**
 * @Describe 全量和已占用字符集 、字符串统计
 * @Author zem
 * @CreateDate 2024/9/2 0002 9:25
 */
public class No5 {

    public static void main(String[] args) {
        solve("a:3,b:5,c:2@a:1,b:2");
    }

    public static void solve(String str) {
        String[] split = str.split("@");
        String canuUse = split[0];
        String used = split[1];
        Map<String, Integer> map = new HashMap<>();
        for (String s : canuUse.split(",")) {
            String[] entry = s.split(":");
            map.put(entry[0], Integer.valueOf(entry[1]));
        }
        if (!used.isEmpty()) {
            for (String s : used.split(",")) {
                String[] entry = s.split(":");
                map.merge(entry[0], Integer.valueOf(entry[1]), (oldV, newV) -> oldV - newV);
            }
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> {
            sb.append(key + ":" + value + ",");
        });
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

}
