package com.zem.algorithm.huawei2024.ex1.no2540ex1no20;

import java.util.Scanner;

/**
 * @Describe todo 需要修复自己的 odoj的数据有问题
 * @Author zem
 * @CreateDate 2024/9/4 0004 9:47
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int realCost = 0;
        while (i > 0) {
            i--;
            realCost++;
            String stri = String.valueOf(i);
            if (stri.contains("4")) {
                stri = stri.replaceAll("4", "3");
                i = Integer.valueOf(stri);
            }
        }
        System.out.println(realCost);
    }
}
