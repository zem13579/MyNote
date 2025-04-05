package com.zem.algorithm.swordoffer;

/**
 * @Describe 数字在排序数组中出现的次数
 * @Author zem
 * @CreateDate 2023/11/23 0023
 */
public class Code38 {
    public static void main(String[] args) {
        //1,2, 3,3,3,3,4,5}
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        Code38 code38 = new Code38();
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
            int next = mid;
            while (next < arr.length && arr[next] == k) {
                next++;
            }
            return --next;
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
            int last = mid;
            while (last >= 0 && arr[last] == k) {
                last--;
            }
            return ++last;
        } else if (arr[mid] < k) {
            return getFirstK(arr, k, mid + 1, end);
        } else {
            return getFirstK(arr, k, start, mid - 1);
        }
    }
}
