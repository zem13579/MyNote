package org.example.sort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> extends SortModelArr<T> {
    @Override
    public void sort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(T[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            this.merge(arr, start, mid, end);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(T[] arr, int start, int mid, int end) {
        T[] temp = (T[]) new Comparable[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (less(arr[i], arr[j])) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 9, 5, 1, 2};
        MergeSort<Integer> integerMergeSort = new MergeSort<>();
        integerMergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
