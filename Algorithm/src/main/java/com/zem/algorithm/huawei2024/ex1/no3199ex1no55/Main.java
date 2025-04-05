package com.zem.algorithm.huawei2024.ex1.no3199ex1no55;

import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/23 0023 14:06
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int productNum = sc.nextInt();
        int totalMoney = sc.nextInt();
        int totalRisk = sc.nextInt();
        int[] reteReturn = new int[productNum];
        for (int i = 0; i < productNum; i++) {
            reteReturn[i] = sc.nextInt();
        }
        int[] risks = new int[productNum];
        for (int i = 0; i < productNum; i++) {
            risks[i] = sc.nextInt();
        }
        int[] maxInvest = new int[productNum];
        for (int i = 0; i < productNum; i++) {
            maxInvest[i] = sc.nextInt();
        }
        int[] maxReturn = new int[5];
        
        //单个投资项目
        for (int i = 0; i < risks.length && risks[i] <= totalRisk; i++) {
            int invest = Math.min(totalMoney, maxInvest[i]);
            int returnMoney = invest * reteReturn[i];
            if (returnMoney > maxReturn[0]) {
                maxReturn = new int[] {returnMoney, invest, 0, i, -1};
            }
        }
        
        //两个投资项目
        for (int i = 0; i < risks.length; i++) {
            for (int j = i + 1; j < risks.length; j++) {
                if (risks[i] + risks[j] <= totalRisk) {
                    int[] returnMoney = calculateReturn(i, j, maxInvest, reteReturn, totalMoney);
                    if (returnMoney[0] > maxReturn[0]) {
                        maxReturn = returnMoney;
                    }
                }
            }
        }
        
        for (int i = 0; i < productNum; i++) {
            if (i == maxReturn[3]) {
                System.out.print(maxReturn[1] + " ");
            } else if (i == maxReturn[4]) {
                System.out.print(maxReturn[2] + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
        
    }
    
    private static int[] calculateReturn(int i, int j, int[] maxInvest, int[] reteReturn, int totalMoney) {
        if (maxInvest[i] + maxInvest[j] > totalMoney) {
            int invest1 = Math.min(maxInvest[i], totalMoney);
            int invest2 = totalMoney - invest1;
            int total1 = invest1 * reteReturn[i] + invest2 * reteReturn[j];
            
            int invest3 = Math.min(maxInvest[j], totalMoney);
            int invest4 = totalMoney - invest3;
            int total2 = invest4 * reteReturn[i] + invest3 * reteReturn[j];
            
            if (total1 <= total2) {
                return new int[] {total2, invest4, invest3, i, j};
            } else {
                return new int[] {total1, invest1, invest2, i, j};
            }
            
        } else {
            int result = maxInvest[i] * reteReturn[i] + maxInvest[j] * reteReturn[j];
            return new int[] {result, maxInvest[i], maxInvest[j], i, j};
        }
        
    }
}
