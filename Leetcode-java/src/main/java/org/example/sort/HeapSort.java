package org.example.sort;

import java.util.Arrays;

/**
 * @author zhang
 */
public class HeapSort<T extends Comparable<T>> extends SortModelArr<T> {
    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        //构建最大堆,根部最大
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            exch(arr, 0, i);
            heapify(arr, i, 0);
        }

    }

    private void heapify(T[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && bigger(arr[left], arr[largest])) {
            largest = left;
        }
        if (right < n && bigger(arr[right], arr[largest])) {
            largest = right;
        }
        if (largest != i) {
            exch(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Integer[] integers = generateUniqueRandomNumbers(100);
        System.out.println(Arrays.toString(integers));
        HeapSort<Integer> integerHeapSort = new HeapSort<>();
        integerHeapSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
