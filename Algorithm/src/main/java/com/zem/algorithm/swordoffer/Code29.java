package com.zem.algorithm.swordoffer;

import java.util.Stack;

/**
 * @Author zem
 * @Date 2023/10/22
 * @Describe 数组中出现次数超过一半的数字
 */
public class Code29 {

    private boolean g_bInputInvalid = false;

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Code29 code29 = new Code29();
        System.out.println(code29.moreThanHalfNum2(test));
    }

    /**
     * @param numbers 排序数组
     * @return
     */
    int moreThanHalfNum(int[] numbers) {
        if (!checkArr(numbers)) {
            return 0;
        }
        int middle = numbers.length >> 1;
        int start = 0;
        int end = numbers.length - 1;
        int index = partition(numbers, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(numbers, start, end);
            } else {
                start = index + 1;
                index = partition(numbers, start, end);
            }
        }
        int result = numbers[middle];
        if (!checkMoreThanHalf(numbers, result)) {
            result = 0;
        }
        return result;

    }

    /**
     * 检测找到的中位数是否已经超过半数
     *
     * @param numbers
     * @param result
     * @return
     */
    private boolean checkMoreThanHalf(int[] numbers, int result) {
        int times = 0;
        for (int number : numbers) {
            if (number == result) {
                times++;
            }
        }
        boolean isMoreThanHalf = true;
        if (times * 2 < numbers.length) {
            g_bInputInvalid = true;
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }

    /**
     * 快速排序
     *
     * @return
     */
    public int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * @param numbers
     * @return
     */
    private boolean checkArr(int[] numbers) {
        g_bInputInvalid = false;
        if (numbers != null || numbers.length == 0) {
            g_bInputInvalid = true;
        }
        return g_bInputInvalid;
    }

    int moreThanHalfNum2(int[] numbers) {
        if (!checkArr(numbers)) {
            return 0;
        }
        int middle = numbers.length >> 1;

        Stack<Integer> stack = new Stack<>();
        for (int number : numbers) {
            if (stack.isEmpty()) {
                stack.push(number);
            } else {
                if (stack.peek().equals(number)) {
                    stack.push(number);
                } else {
                    stack.pop();
                }
            }
        }

        int result = stack.pop();
        if (!checkMoreThanHalf(numbers, result)) {
            result = 0;
        }
        return result;
    }
}
