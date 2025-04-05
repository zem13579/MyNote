package com.zem.algorithm.swordoffer;

/**
 * @Describe n个骰子的点数
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * @Author zem
 * @CreateDate 2023/11/24 0024
 */
public class Code43 {
    public static void main(String[] args) {
        Code43 code43 = new Code43();
        code43.printProbability2(3);
    }

    private double SINGLE_PROBABILITY = 0.0;

    /**
     * 基于递归求
     *
     * @param numberOfdice
     */
    public void printProbability(int numberOfdice) {
        //该数组的下标代表了和,数值代表了出现次数
        int[] probabilityArr = new int[numberOfdice * 6 + 1];

        func1(probabilityArr, numberOfdice, 0);

        for (int i = 0; i < probabilityArr.length; i++) {
            System.out.println(i + "\t" + probabilityArr[i]);
        }

    }

    private void func1(int[] probabilityArr2, int time, int sum) {
        if (time == 0) {
            probabilityArr2[sum]++;
            return;
        }
        for (int i = 1; i <= 6; i++) {
            func1(probabilityArr2, time - 1, sum + i);
        }
    }

    /**
     * 基于循环求骰子点数
     *
     * @param numberOfdice
     */
    public void printProbability2(int numberOfdice) {
        int[][] probabilityArr = new int[2][numberOfdice * 6 + 1];

        int flag = 0;
        //初始化可能次数，异地轮1-6都是有一次可能
        for (int i = 1; i <= 6; i++) {
            probabilityArr[flag][i] = 1;
        }
        //从第二次开始
        for (int k = 2; k <= numberOfdice; ++k) {
            for (int i = 0; i < k; i++) {
                //将和为k-1前的次数初始化为0，4枚骰子无法投出和为3的情况，同样2也不行
                probabilityArr[1 - flag][i] = 0;
            }
            //代表了一轮骰子的可能取值上限 6*k
            for (int i = k; i <= 6 * k; i++) {
                //将本次要计算的一侧数组设置为0
                probabilityArr[1 - flag][i] = 0;
                //代表了6种可能性，其中j<=i 防止数组越界
                for (int j = 1; j <= i && j <= 6; ++j) {
                    probabilityArr[1 - flag][i] += probabilityArr[flag][i - j];
                }
            }
            flag = 1 - flag;
        }

        double total = Math.pow(6.0, numberOfdice);
        for (int i = numberOfdice; i <= numberOfdice * 6; i++) {
//            double ratio = (double) probabilityArr[flag][i]/total;
            System.out.printf("%d:%d\n", i, probabilityArr[flag][i]);
        }
    }
}
