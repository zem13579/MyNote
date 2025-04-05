package com.zem.algorithm.swordoffer;

/**
 * @Author zem
 * @Date 2023/10/19
 */
public class Code24 {
    public static void main(String[] args) {
        int[] arr = {7, 4, 6, 5};
        Code24 code24 = new Code24();
        Boolean b = code24.verifySquenceOfBST(arr, arr.length);
        System.out.println(b);
    }

    Boolean verifySquenceOfBST(int[] sequence, int length) {
        if (sequence == null || length <= 0) {
            return false;
        }

        int root = sequence[length - 1];

        int i = 0;
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        for (int j = i; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > 0) {
            left = verifySquenceOfBST(sequence, i);
        }

        boolean right = true;
        if (i < length - 1) {
            int[] rightSequence = new int[length - i - 1];
            System.arraycopy(sequence, i, rightSequence, 0, length - i - 1);
            right = verifySquenceOfBST(rightSequence, length - i - 1);
        }

        return left && right;
    }
}
