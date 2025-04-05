package com.zem.algorithm.swordoffer;

import org.junit.jupiter.api.Test;

class Code38Test {

    @Test
    public void test() {
        //1,2, 3,3,3,3,4,5}
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        Code38Test code38 = new Code38Test();
        System.out.println(code38.getNumerOfK(arr, 3));
    }

    public int getNumerOfK(int[] arr, int k) {
        int firstPosition = getFirstK(arr, k, 0, arr.length - 1);
        int lastPosition = getLastK(arr, k, 0, arr.length - 1);
        if (firstPosition != -1 && lastPosition != -1) {
            return lastPosition - firstPosition + 1;
        }
        return 0;
    }

    private int getLastK(int[] arr, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == k) {
            if (mid < arr.length - 1 && arr[mid + 1] != k || mid == arr.length - 1) {
                return mid;
            } else {
                return getLastK(arr, k, mid + 1, end);
            }
        } else if (arr[mid] < k) {
            return getLastK(arr, k, mid + 1, end);
        } else {
            return getLastK(arr, k, start, mid - 1);
        }
    }

    private int getFirstK(int[] arr, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == k) {
            if (mid > 0 && arr[mid - 1] != k || mid == 0) {
                return mid;
            } else {
                return getFirstK(arr, k, start, mid - 1);
            }
        } else if (arr[mid] < k) {
            return getFirstK(arr, k, mid + 1, end);
        } else {
            return getFirstK(arr, k, start, mid - 1);
        }
    }


}