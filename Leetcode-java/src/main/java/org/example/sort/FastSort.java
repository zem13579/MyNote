package org.example.sort;

import java.util.Arrays;

/**
 * @author zhang
 */
public class FastSort<T extends Comparable<T>> extends SortModelArr<T> {
    @Override
    public void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        //指向小于pivot的最大的一个
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (less(arr[j], pivot)) {
                //保证所有都小于pivot
                i++;
                exch(arr, i, j);
            }
        }
        exch(arr, i + 1, high);
        return i + 1;
    }

    public static void main(String[] args) {
        Integer[] integers = generateUniqueRandomNumbers(100);
        FastSort<Integer> integerFastSort = new FastSort<>();
        integerFastSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
