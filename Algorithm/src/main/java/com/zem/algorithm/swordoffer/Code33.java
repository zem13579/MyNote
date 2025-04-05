package com.zem.algorithm.swordoffer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zem
 * @Date 2023/10/24
 * @Describe 把数组排成最小的数
 */
public class Code33 {
    public static void main(String[] args) {
        String[] strs = {"3", "32", "321", "1"};
        Code33 code33 = new Code33();
        code33.minNumberInArr(strs);
    }

    public void minNumberInArr(String[] arr) {
        List<String> collect = Arrays.stream(arr)
                .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1))
                .collect(Collectors.toList());

        for (String s : collect) {
            System.out.print(s);
        }
    }
}
