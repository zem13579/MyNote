package com.zem.algorithm.swordoffer;

import java.util.Arrays;

/**
 * @Describe 扑克牌的顺子
 * @Author zem
 * @CreateDate 2023/11/25 0025
 */
public class Code44 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 6, 5};
        Code44 code44 = new Code44();
        System.out.println(code44.IsContinuous(arr));
    }

    public boolean IsContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 1) return false;
        Arrays.sort(numbers);

        int numberOfZero = 0;
        int numberOfGap = 0;

        //统计数组中0的个数
        for (int number : numbers) {
            if (number == 0) numberOfZero++;
        }

        //统计数组中的间隔个数
        int small = numberOfGap;
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) return false;
            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return !(numberOfGap > numberOfZero);
    }
}
