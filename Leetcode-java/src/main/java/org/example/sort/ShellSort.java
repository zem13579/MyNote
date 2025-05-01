package org.example.sort;

import java.util.Arrays;

public class ShellSort<T extends Comparable<T>> extends SortModelArr<T> {
    @Override
    public void sort(T[] arr) {
        int length = arr.length;
        int gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                T key = arr[i];
                int j = i;
                while (j >= gap && less(key, arr[j - gap])) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
            gap = gap / 2;
        }
    }

    public static void main(String[] args) {
        ShellSort<Integer> integerShellSort = new ShellSort<>();
        Integer[] arr = {21,3, 121};
        integerShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
