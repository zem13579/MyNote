package com.zem.algorithm.swordoffer;

/**
 * @Describe 和为s的两个数字VS和为s的连续正数序列
 * @Author zem
 * @CreateDate 2023/11/23 0023
 */
public class Code41 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 11, 15};
        int sum = 15;
        Code41 code41 = new Code41();
        code41.findNumbersWithSum(arr, sum);
        code41.findNumberSequenceWithSum(4);
    }

    public void findNumbersWithSum(int[] arr, int sum) {
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end && begin >= 0 && end < arr.length) {
            int currentSum = arr[begin] + arr[end];
            if (currentSum < sum) {
                begin++;
            } else if (currentSum > sum) {
                end--;
            } else {
                break;
            }
        }
        System.out.println(arr[begin] + "\t" + arr[end]);
    }

    /**
     * 题目二：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8
     */

    public void findNumberSequenceWithSum(int sum) {
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;
        while (small < middle) {
            if (curSum == sum) {
                printSequence(small, big);
            }
            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    printSequence(small, big);
                }
            }
            big++;
            curSum += big;
        }
    }

    private void printSequence(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i + "\t");
        }
        System.out.print("\n");
    }


}
