package com.zem.algorithm.huawei2024.ex1.no3206ex1no8;

import java.util.*;

/**
 * @Describe 这题必须用双指针才能通过
 * @Author zem
 * @CreateDate 2024/9/2 0002 11:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flaw = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String dict = "aeiouAEIOU";
        Set<Character> dictSet = new HashSet<>();
        for (char c : dict.toCharArray()) {
            dictSet.add(c);
        }
        //记录所有为元音字母的索引编号
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (dictSet.contains(s.charAt(i))) {
                indexs.add(i);
            }
        }
        int maxLength = 0;
        for (int i = 0, j = 0; j < indexs.size(); ) {
            Integer left = indexs.get(i);
            Integer right = indexs.get(j);
            int noperfect = indexs.get(j) - indexs.get(i) - (j - i);
            if (noperfect > flaw) {
                //超出了预期，则左指针右移
                i++;
            } else if (noperfect == flaw) {
                //如果为等于，则记录下长度
                int length = right - left + 1;
                if (length > maxLength) {
                    maxLength = length;
                }
                j++;
            } else {
                //小于则跳过
                j++;
            }
        }
        System.out.println(maxLength);
    }
}
