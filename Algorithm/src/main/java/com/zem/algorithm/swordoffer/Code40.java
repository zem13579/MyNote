package com.zem.algorithm.swordoffer;

/**
 * @Describe 数组中只出现一次的数字
 * @Author zem
 * @CreateDate 2023/11/23 0023
 */
public class Code40 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 3, 2, 5, 5, 7, 7};
        Code40 code40 = new Code40();
        code40.findNumsAppearOnce(arr);
    }

    public void findNumsAppearOnce(int[] arr) {
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        for (int i : arr) {
            result ^= i;
        }
        int index = findFistBitIs1(result);
        for (int i : arr) {
            if (isBit1(i, index)) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        System.out.println(num1 + "\t" + num2);
    }

    /**
     * 找到最右第一位为 1 时的 index
     *
     * @param num
     * @return
     */
    private int findFistBitIs1(int num) {
        int index = 0;
        while (((num & 1) == 0) && index < Integer.SIZE) {
            num = num >> 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }

}
