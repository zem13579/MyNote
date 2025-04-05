package com.zem.algorithm.huawei2024.ex1.no3204ex1no17;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //初始化最长子串长度为-1
        int maxLength = -1;
        // 表示是否找到了包含了字母的子串
        boolean hasLetter = false;
        int l = 0, r = 0;
        //字母的索引
        Deque<Integer> letterIndex = new ArrayDeque<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            if (Character.isLetter(c)) {
                hasLetter = true;
                letterIndex.addLast(r);
                //此处>1 确实是厉害，不是绝对的指向字母
                // 只有当第二个字母在字符串中出现时，自动的跳过
                if (letterIndex.size() > 1) {
                    l = letterIndex.removeFirst() + 1;
                }
                if (r == l) {
                    r++;
                    continue;
                }
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        if (!hasLetter) {
            System.out.println(-1);
        } else {
            System.out.println(maxLength);
        }
    }


}
