package org.example.sort;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> extends SortModelArr<T> {
    @Override
    public void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean changed = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (less(arr[j + 1], arr[j])) {
                    exch(arr, j + 1, j);
                    changed = true;
                }
            }
            if (!changed) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort<Integer> integerBubbleSort = new BubbleSort<>();
        Integer[] arr = {4, 5, 1, 2};
        integerBubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
