package com.zem.algorithm.huawei2024.ex1.no3106ex1no72;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/13 0013 15:09
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int childInOne = entry.getKey() + 1;
            Integer count = entry.getValue();
            int numOfCommunity = (int) Math.ceil((double) count / childInOne);
            sum += numOfCommunity * childInOne;
        }
        System.out.println(sum);
    }
    
}
